package bridge.view

import bridge.utils.InputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class InputViewTest {
    @ValueSource(strings = ["a", "0", "999", "-123"])
    @ParameterizedTest
    fun `입력 테스트`(input: String) {
        assertThrows<IllegalArgumentException> { InputValidator().validateBridgeSize(input) }
    }
}