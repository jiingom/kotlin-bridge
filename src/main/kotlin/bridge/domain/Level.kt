package bridge.domain

enum class Level(
    private val upOrDown: String,
    private val successOrFail: String
) {
    UP("U", "O"),
    DOWN("D", "O"),
    UP_FAIL("U", "X"),
    DOWN_FAIL("D", "X");

    fun upOrDown() = this.upOrDown
    fun successOrFail() = this.successOrFail
}