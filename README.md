# OOPS_Lab5

![Sequence Diagra](Untitled.png)

Questions

Pt 3
1. instead of depending on a concrete class it now depends on a common interface
2. new book types can be added without changing the whole system
3. the new sub class can have anyextensions without changing the base system since it now relies on the interface
4. makes code more interchangble and maintable

Pt 4
2. a more gneral interface could be made that in clude all rental/borrow items and all item (including book could use that interface). If DIP was not applied you would have to use if else statments that would get updated for each new item added or removed changing the system each time reducing maintainability and flexibility.

Pt 5
I ensured the member class adhered to the SRP by removing the responsibility of book borrowing, and shifting it to it’s own class.
I chose to use a class and an interface because it’s the only non-member responsibility contained in that class, I would personally use a class only, as an interface increases complexity. Although using one allows for making a “contract”, I don’t foresee any other extensions for the borrowingService class that would warrant using one.
I encountered no tradeoffs, nor challenges. They are best practices specifically because they avoid challenges and tradeoffs aside from a higher class count.

Pt 6
returnBook, book is overdue. Could be handled by optionally passing a due date, and passing out the fee via borrowingbookresult. It would require a new signature, but very little new code
borrowBook, book is reserved, has additional copies. Simple if clause in borrowingService. Must be handled by editing the book class to add reserved status per item, and book quantity, increments and decrements in borrowingSerivce.
borrowBook, member has suspended library card. Could be handled with an if clause in borrowingService, but requires adding an active boolean attribute to Member.

The Factory Method pattern was used so the system does not need to rely on directly creating specific book types using the new keyword. Instead, book creation is handled by factory classes (PaperBookFactory, EBookFactory, AudioBookFactory) that decide which type of Book to create. Also, this improves flexibility because new book types can be added without changing any existing controller logic, only a new factory class needs to be implemented .
It reduces tight coupling between the controller and concrete book classes. It also supports the Open/Closed Principle by allowing new book types to be added without modifying controller code.
It adds more classes to the project, which can make the system feel more complicated than necessary, especially when the application is still fairly small. For simple programs, using factories instead of new can feel like extra work, since direct object creation would be quicker and easier to understand.

Pt 7.

The BorrowingService class was implemented as a Singleton and injected into each Member through the LibrarianController. The design makes sure that all borrowing and returning operation are handled by a single, shared service instance, which centralizes the business rules for availability checks and borrowing limits. Using Singeleton helps reduce dupliacation of logic and state throughout the system and makes it easier to change borrowing policies in one place rather than updating multiple classes.
