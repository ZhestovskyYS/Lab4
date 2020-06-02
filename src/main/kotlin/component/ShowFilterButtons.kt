package component

import container.filterLink
import data.Display
import react.RBuilder
import react.dom.div
import react.dom.span

fun RBuilder.showFButtons() =
    div {
        span { +"Show: " }
        filterLink{
            attrs.filter = Display.All
            +"All"
        }

        filterLink{
            attrs.filter = Display.ThosePresent
            +"Those Present"
        }

        filterLink {
            attrs.filter = Display.ThoseMissing
            +"Those Missing"
        }
}