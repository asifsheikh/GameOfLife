import com.google.common.truth.Truth.assertThat
import org.junit.Test

class CanaryTest {
    @Test
    fun `should test if the test environment is setup properly`() {
        assertThat(true)
            .isTrue()
    }
}