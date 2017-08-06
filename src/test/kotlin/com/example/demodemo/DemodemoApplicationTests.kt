package samples.demodemo

import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DemodemoApplicationTests {



	@Test
	fun contextLoads() {
	}

}
