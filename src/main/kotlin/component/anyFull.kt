package component

import org.w3c.dom.events.Event
import react.*
import react.dom.*
import react.functionalComponent

interface AnyFullProps<O, S> : RProps {
    var obj: Pair<Int, O>
    var subobjs: Map<Int, S>
    var presents: Map<Int, Boolean>?
    var onClick: (Int) -> (Event) -> Unit
}

fun <O, S> fAnyFull(
    rComponent: RBuilder.(S, String, (Event) -> Unit) -> ReactElement
) =
    functionalComponent<AnyFullProps<O, S>> { props ->
        h3 {
            +props.obj.second.toString()
        }
        showFButtons()
        ul {
            props.subobjs.map{
                val present = props.presents?.get(it.key)?:false
                val cssClass = if(present) "present" else "absent"
                li {
                    rComponent(it.value, cssClass, props.onClick(it.key))
                }
            }
        }
    }
