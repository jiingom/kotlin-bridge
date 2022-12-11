package bridge.controller

import bridge.BridgeMaker
import bridge.BridgeRandomNumberGenerator
import bridge.domain.BridgeGame
import bridge.view.InputView
import bridge.view.OutputView

class GameController {
    fun run() {
        val bridge = createBridge()
        progressGame(bridge)
    }

    private fun progressGame(bridge: List<String>) {
        val game = BridgeGame(bridge)
        var gameContinue = true
        while (!game.isClear() && gameContinue) {
            gameContinue = move(game)
            if (!gameContinue) {
                gameContinue = retry(game)
            }
        }
        OutputView().printResult(game)
    }

    private fun move(game: BridgeGame): Boolean {
        val move = validateMove()
        val gameContinue = game.move(move)
        OutputView().printMap(game.get())
        return gameContinue
    }

    private fun retry(game: BridgeGame): Boolean {
        val retry = validateRetry()
        return game.retry(retry)
    }

    private fun createBridge(): List<String> {
        val size = validateBridgeSize()
        return BridgeMaker(BridgeRandomNumberGenerator()).makeBridge(size)
    }

    private fun validateBridgeSize(): Int {
        while (true) {
            try {
                return InputView().readBridgeSize()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateMove(): String {
        while (true) {
            try {
                return InputView().readMoving()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateRetry(): String {
        while (true) {
            try {
                return InputView().readGameCommand()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}