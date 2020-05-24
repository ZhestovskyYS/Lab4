package component

import kotlinx.html.InputType
import kotlinx.html.id
import react.RBuilder
import react.RProps
import react.dom.input
import react.functionalComponent
import react.child

fun RBuilder.LessonField() =
    child(functionalComponent<RProps> {
        input(InputType.text){
            attrs {
                placeholder = "Enter lesson"
                id = "lesson"
            }
        }
    })