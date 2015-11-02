$(function() {
	'use strict';
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
	};
	new Game();
});