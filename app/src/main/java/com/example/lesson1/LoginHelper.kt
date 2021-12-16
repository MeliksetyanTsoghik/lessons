package com.example.lesson1

data class User(var mail: String = "",
                var login: String = "",
                var password: String = "",
                var imageUrl: String = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgqLqC18yVDR5mTQE9jI2FuPXxSlxVPk672GG9lgR6lB-pgSUo2m8KQP6PfRM4_fqLQkk&usqp=CAU")

val users = mutableListOf<User>()

fun addUser(newUser: User) : Boolean{
    for (user in users) {
        if (newUser.login == user.login) return false
    }
    users.add(newUser)
    return true
}

fun fillFakeData() {
    addUser(User("lero@mail.com", "leroLog", "12345666", ))
    addUser(User("hovo@mail.com", "hovoLog", "12345666", ))
    addUser(User("nare@mail.com", "NareLog", "12345666",))
}

fun haveSuchUser(enteredLogin: String, enteredPass: String) : Boolean{
    users.forEach{ user ->
        if (user.login == enteredLogin && user.password == enteredPass) {
            return true
        }
    }
    return false
}