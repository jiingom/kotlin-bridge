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

    companion object {
        const val BRIDGE_SIZE_ERROR = "[ERROR]: 다리의 길이는 3에서 20사이의 정수여야 합니다."
    }
}