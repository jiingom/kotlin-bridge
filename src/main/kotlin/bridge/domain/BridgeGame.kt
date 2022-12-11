package bridge.domain

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame(private val bridge: List<String>) {
    private var progressBridge = mutableListOf<Level>()
    private var level = 0
    private var tryCount = 1
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun move(movement: String): Boolean {
        return updateGame(movement)
    }

    private fun updateGame(movement: String): Boolean {
        if (bridge[level] == movement) {
            updateUpBridge(movement)
            level++
            return true
        }
        updateDownBridge(movement)
        return false
    }

    private fun updateUpBridge(movement: String) {
        when (movement) {
            "U" -> progressBridge.add(Level.UP)
            "D" -> progressBridge.add(Level.DOWN)
        }
    }

    private fun updateDownBridge(movement: String) {
        when (movement) {
            "U" -> progressBridge.add(Level.UP_FAIL)
            "D" -> progressBridge.add(Level.DOWN_FAIL)
        }
    }

    fun isClear(): Boolean {
        return level == bridge.size
    }

    fun get(): List<Level> {
        return progressBridge
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry(input: String): Boolean {
        if (input == "R") {
            level = 0
            progressBridge = mutableListOf()
            tryCount++
            return true
        }
        return false
    }
}
