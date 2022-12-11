import csstype.Color
import emotion.react.css
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.useEffectOnce
import react.useState

suspend fun count(update: (Int) -> Unit) {
    var counter = 0
    @Suppress("UNREACHABLE_CODE") // IDEA thinks "return" is unreachable code, why?
    return coroutineScope {
        while (true) {
            delay(1000)
            counter += 1
            update(counter)
        }
    }
}

val mainScope = MainScope()

val App = FC<Props> {
    var counter: Int by useState(0)

    useEffectOnce {
        mainScope.launch {
            count { c -> counter = c }
        }
    }

    h1 {
        css {
            color = Color("red")
        }
        +"Hello, React+Kotlin/JS!"
    }
    div {
        +"Counter: $counter"
    }
}