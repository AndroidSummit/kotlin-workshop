# Kotlin Workshop
## By [Aaron Sarazan](https://github.com/asarazan)

This workshop will have you build a modern notepad app using the [Kotlin](https://kotlinlang.org/) language. 

It will also lean on other modern tools such as [Room](https://developer.android.com/topic/libraries/architecture/room.html) for persistence, 
[RxJava](https://github.com/ReactiveX/RxJava) for observing, 
and [ThreeTenABP](https://github.com/JakeWharton/ThreeTenABP) for date handling.

## Preparation

### Android Studio
Before the session begins, please install [Android Studio 3.0 Beta 2](https://developer.android.com/studio/archive.html) and make sure this repo builds successfully.

### Android Device / Emulator
Please make sure you either have a device and cable to run the application, or that you have an emulator set up and running ahead of time.

### Open Documentation
We will occasionally be referring directly to the Room documentation. We will also be taking a quick look at Anko:
* https://developer.android.com/topic/libraries/architecture/room.html
* https://github.com/Kotlin/anko

## [Step 1](https://github.com/AndroidSummit/kotlin-workshop/tree/step/1)
In the first section, we get our tools set up, fire up the emulator, and introduce everybody to our excellent helpers: [Tre Murillo](https://github.com/treelzebub), [Steven Anyanwu](https://github.com/sawsegit), [Enrique Portillo](https://github.com/tembloroso), and [Josh Shin](https://github.com/vaudevillainous). We will examine our gradle configuration, and also create a basic main activity, and go over some of the auto-generated Kotlin code.

#### Topics Covered
* Tools
* Kotlin's Gradle plugins
* Basic syntax
* Lambdas
* Death to `findViewById`!

## [Step 2](https://github.com/AndroidSummit/kotlin-workshop/tree/step/2)
Moving on, we will look into the Kotlin annotation processor. We'll also create our `Note` data object, complete with [JSR-310](https://github.com/JakeWharton/ThreeTenABP) date field.

After that we'll set up all of Room's required scaffolding, such as `TypeConverter`, `RoomDatabase`, and our `DAO`. We'll create a couple of query functions as well!

#### Topics Covered
* Annotation Processing
* Java->Kotlin autoconversion
* Nullability
* Type Inference
* `@JvmStatic` and singletons
* varargs

## [Step 3](https://github.com/AndroidSummit/kotlin-workshop/tree/step/3)
Now that we've set up the core of our persistence logic, let's write a quick smoke test to make sure everything is hooked up properly. We'll demonstrate the power of the Kotlin auto-converter by directly converting a sample test from the Room website.

#### Topics Covered
* Testing with Kotlin
* `lateinit`
* The `apply` function
* `Foo::class.java`

## [Step 4](https://github.com/AndroidSummit/kotlin-workshop/tree/step/4)
Here we set up our recycler adapter, abstract out our database objects into the `DataStore` singleton, and introduce RxJava!

#### Topics Covered
* How Kotlin handles inner classes
* Secondary & primary constructors
* Null coalescing
* Subscript operator for collections
* private setters

## [Step 5](https://github.com/AndroidSummit/kotlin-workshop/tree/step/5)
The final stretch! Let's add some convenience extensions to LayoutInflater and RxJava, set up our composition Activity, and introduce Anko for easy async execution.

#### Topics Covered
* Convenience extensions
* `when` expression
* Anko for async

**What a pretty app!**
