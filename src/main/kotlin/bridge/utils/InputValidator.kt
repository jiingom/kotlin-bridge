package bridge.utils

class InputValidator {
    fun validateBridgeSize(size: String): Int {
        require(size.all { it in '0'..'9' } &&
                size.toInt() >= 3 &&
                size.toInt() <= 20) {
            BRIDGE_SIZE_ERROR
        }
        return size.toInt()
    }

    fun validateMove(move: String): String {
        require(
            move == "U" ||
                    move == "D"
        ) {
            MOVE_ERROR
        }
        return move
    }

    companion object {
        const val BRIDGE_SIZE_ERROR = "[ERROR]: 다리의 길이는 3에서 20사이의 정수여야 합니다."
        const val MOVE_ERROR = "[ERROR]: U(위 칸) 혹은 D(아래 칸) 여야 합니다."
    }
}