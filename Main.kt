fun main(){
    data class Task (val id: Int, val title: String, val description: String) //creating a class for making objects with data class so we would be able to read it
    var alltodo: MutableList<Task> = mutableListOf() //empty mutuble array
    var idwillbe: Int = 1

    while (true){ // countiniusly ask for command -> var command = readLine()!!.toIntOrNull();
        println("What do you want to do ? 1) See todos 2) Add a todo 3) Remove a todo")
        var command = readLine()!!.toIntOrNull(); //whenever user type a non Int value it is gonna convert it into a null value
        if (command == null) {
            println("Enter a valid command")
            continue
        }
        when(command){
            1 -> if (alltodo.isEmpty()) println("No task aviable") else {for (task in alltodo) println(task)}
            2 -> {
                println("Write the title")
                var title = readLine()!!
                println("Write the description")
                var description = readLine()!!
                var newtask = Task(idwillbe, title, description)
                alltodo.add(newtask)
                println("Task added with the id of $idwillbe")
                idwillbe++ //add by 1 every time new task published
            }
            3 -> {
                println("Write the id");
                var id = readLine()!!.toInt()
                if (!alltodo.isEmpty()){
                    var delitem = alltodo.find {todo -> todo.id == id}
                    if (delitem != null) {
                        alltodo.remove(delitem)
                    } else {
                        println("No task found with this id of $id")
                    }
                }else{
                    println("List is empty")
                }

            }
            0 -> return //exit the program
            else -> println("Enter a valid option")
        }
    }
}
