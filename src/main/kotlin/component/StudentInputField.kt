package component

import kotlinx.html.InputType
import kotlinx.html.id
import react.RBuilder
import react.RProps
import react.child
import react.dom.input
import react.functionalComponent

fun RBuilder.StudentField () =
    child(functionalComponent<RProps> {
        input(InputType.text){
            attrs{
                placeholder = "Enter student first name"
                id = "FName"
            }
        }
        input(InputType.text){
            attrs {
                placeholder = "Enter student sure name"
                id = "SName"
            }
        }
    })
