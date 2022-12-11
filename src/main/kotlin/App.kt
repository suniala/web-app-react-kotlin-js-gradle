import csstype.Color
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.h1

val App = FC<Props> {
    h1 {
        css {
            color = Color("red")
        }
        +"Hello, React+Kotlin/JS!"
    }
}