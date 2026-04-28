package id.my.sendiko.scanner

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform