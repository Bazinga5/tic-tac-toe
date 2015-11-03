$(function() {
	'use strict';
	var MOVE_URL_ = 'player-move';
	var NEW_GAME_URL_ = 'new-game';

	function Game() {
		this.boardTemplate_ = $('#tpl-board').html();
		this.message_ = $('#game__message');
		this.restart_ = $('#game__restart');
		this.outlet_ = $('#game__outlet');
		this.loadingTemplate_ = $('<i class="is_loading"></i>');
		this.newGame();
	}

	Game.prototype.startLoading_ = function() {
		this.loading_ = this.loadingTemplate_.clone().prependTo('body');
	};

	Game.prototype.endLoading_ = function() {
		this.loading_.remove();
		this.loading_ = null;
	};

	Game.prototype.newGame = function() {
		this.startLoading_();
		return $.post(NEW_GAME_URL_).done(this.createBoard.bind(this));
	};

	Game.prototype.createBoard = function() {
		this.board_ = $(this.boardTemplate_);
		this.outlet_.html(this.board_);
		this.endLoading_();
		this.board_.on('click', 'a', this.handleGameMove.bind(this));
	};

	Game.prototype.updateCell = function(data) {
		this.state_ = JSON.parse(data);
		this.currentCell_.text(this.state_.player);

		if (this.state_.status === 1) {
			this.gameOver();
		} else if (this.state_.status === 2) {
			this.message_.addClass('game__message_tie');
			this.gameOver();
		}

		this.endLoading_();
	};

	Game.prototype.gameOver = function() {
		this.message_.html(this.state_.message);
		this.restart_.show();
	};

	Game.prototype.handleGameMove =	function(event) {
		var cell = $(event.target);

		if (this.loading_ || cell.text().length) {
			return;
		}

		this.currentCell_ = cell;
		this.startLoading_();

		$.post(MOVE_URL_, {move: this.currentCell_.parent().data('col')})
			.done(this.updateCell.bind(this));
	};

	new Game();
});