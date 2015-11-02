$(function() {
	'use strict';
	var MOVE_URL_ = 'player-move';
	var NEW_GAME_URL_ = 'new-game';

	function Game() {
		this.boardTemplate_ = $('#tpl-board').html();
		this.message_ = $('#game__message');
		this.restart_ = $('#game__restart');
		this.outlet_ = $('#game__outlet');
		this.newGame();
	}

	Game.prototype.newGame = function() {
		return $.post(NEW_GAME_URL_).done(this.createBoard.bind(this));
	};

	Game.prototype.createBoard = function() {
		this.board_ = $(this.boardTemplate_);
		this.outlet_.html(this.board_);
		this.board_.on('click', 'td', this.handleGameMove.bind(this));
	};

	Game.prototype.updateCell = function(data) {
		this.state_ = JSON.parse(data);
		this.currentCell_.text(this.state_.player);
	};

	Game.prototype.handleGameMove =	function(event) {
		var cell = $(event.target);
		this.currentCell_ = cell;

		$.post(MOVE_URL_, {move: this.currentCell_.data('col')})
			.done(this.updateCell.bind(this));
	};

	new Game();
});