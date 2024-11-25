// Base class - Item (Super class)
open class Item(val title: String, val author: String) 
{
    open fun displayDetails() 
    {
        println("Title: $title")
        println("Author: $author")
    }
}

// Derived class - Book (Sub-class inheriting from Item)
class Book(title: String, author: String, val genre: String) : Item(title, author) 
{
    override fun displayDetails() 
    {
        super.displayDetails()
        println("Genre: $genre")
    }
}

// Derived class - Magazine (Sub-class inheriting from Item)
class Magazine(title: String, author: String, val issue: String) : Item(title, author) 
{
    override fun displayDetails() 
    {
        super.displayDetails()
        println("Issue: $issue")
    }
}

// Library class to manage books and magazines
class Library {
    private val items: MutableList<Item> = mutableListOf()

    fun addItem(item: Item) 
    {
        items.add(item)
    }

    fun showAllItems() 
  {
        for (item in items) 
        {
            item.displayDetails()
            println("------------------------")
        }
    }
}

fun main() 
{
    // Create instances of books and magazines
    val book1 = Book("Kotlin for Beginners", "John Doe", "Programming")
    val magazine1 = Magazine("Tech World", "Jane Doe", "January 2024")

    // Create a library object
    val library = Library()

    // Add items to the library
    library.addItem(book1)
    library.addItem(magazine1)

    // Display all items in the library
    library.showAllItems()
}
