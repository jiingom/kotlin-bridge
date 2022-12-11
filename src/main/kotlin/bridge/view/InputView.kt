package bridge.view

import bridge.utils.InputValidator
import camp.nextstep.edu.missionutils.Console


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    fun readBridgeSize(): Int {
        println(INPUT_BRIDGE_SIZE_MESSAGE)
        return InputValidator().validateBridgeSize(Console.readLine())
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    fun readMoving(): String {
        println(INPUT_MOVE_MESSAGE)
        return InputValidator().validateMove(Console.readLine())
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    fun readGameCommand(): String {
        return ""
    }

    companion object {
        const val INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요."
        const val INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)"
    }
}
