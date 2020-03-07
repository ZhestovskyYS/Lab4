import data.studentList
import data.Student
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlinx.html.js.*
import kotlinx.html.js.input
import kotlinx.html.js.li
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import kotlin.browser.document
import kotlin.dom.clear

var ascending = true

fun main() {

    document.getElementById("root")!!
        .append {
            h1 {
                attributes += "id" to "header"
                +"Students"
                onClickFunction = onCLickFunction()
            }
            ol {
                attributes += "id" to "listStudents"
                studentList.map {
                    li {
                        +"${it.firstname} ${it.surname}"
                        onClickFunction = prescence(it)
                    }
                }
            }
         radioButtons(colors = arrayListOf("Yellow", "Pink", "LightGreen"))
        }
}

private fun LI.prescence(Student :Student): (Event) -> Unit {
    return{
        val student = document.getElementById(Student.firstname)!!
        if (Student.presence) {
            student.setAttribute("style", "color:grey")
            Student.presence = false
        }
        else {
            student.setAttribute("style", "color: white")
            Student.presence = true
        }
    }
}

private fun H1.onCLickFunction(): (Event) -> Unit {
    return {
        val listStudents = document.getElementById("listStudents")!!
        listStudents.clear()
        listStudents.append {
            if (ascending)
                studentList.sortBy { it.firstname }
            else
                studentList.sortByDescending { it.firstname }
            ascending = !ascending

            studentList.map {
                li {
                    attributes += "id" to it.firstname
                    +"${it.firstname} ${it.surname}"
                    onClickFunction = prescence(it)
                }
            }
        }
    }
}

fun TagConsumer<HTMLElement>.radioButtons(colors: List<String>, classes: String? = null, block: P.() -> Unit = {})
    :HTMLElement =p(classes){
    colors.forEach{
        +it
        input(InputType.radio, name = "radioButtons") {
            value = it
            onClickFunction = {
                document.getElementById("root")!!
                    .setAttribute("style", "color: ${value}")
            }
        }
        br
    }
    block()
}


