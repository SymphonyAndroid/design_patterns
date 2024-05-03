# Лабораторна робота #1
# Опис
Додаток "Склад".
Доступний функціонал:
- Створення прибуткової накладної (поповнення залишків на складі)
- Створення видаткової накладної (вивантаження залишків)
- Перегляд наявних залишків
- Перегляд історії накладних

# Запуск
1. Запустити IntelliJ IDEA
2. Запуск виконуються у методі [`main`](src/Main.java#L18)

# Programming Principles
- ## DRY (Don`t repeat yourself)
  Повторення коду в програмі відсутнє
- ## KISS (Keep It Simple, Stupid)
  Простий метод для виведення історії накладних [`showReporting()`](src/warehouse/Warehouse.java#L88)
- ## YAGNI (You Ain't Gonna Need It)
  Програма не містить функціоналу, який не використовується
- ## Program to Interfaces not Implementations
  Програма містить інтерфейс [`Place`](src/warehouse/Place.java) та його дочірній клас [`Warehouse`](src/warehouse/Warehouse.java).
  Таким чином ми можемо легко додати нову комірку (або щось інше) яка матиме ті самі методи, але змінити їх функціонал який нам необхідно.- ## Composition Over Inheritance
- ## Fail Fast
  Програма містить метод [`getCurrency()`](src/money/Money.java#L28) містить обробку типів класів, але якщо ми викличем цей метод у класі який тут не оброблений - отримаємо помилку.
  Це дозволить нам швидко її знайти та виправити.
- ## SOLID
    - ### Single responsibility
      [`ArrivalReporting`](src/reporting/ArrivalReporting.java) - приклад класу у якого лише одна відповідальність - продукт який прибув на склад, і не впливає на інші сутності.
    - ### Open/closed
      Клас [`Product`](src/product/Product.java) дотримується цього принципу.
      Дочірні краси не можуть змінювати його методи
    - ### Liskov substitution 
      Метод [`showReporting()`](src/warehouse/Warehouse.java#L88) виводить інформацію про накладну незалежно від її типу ([`ArrivalReporting`](src/reporting/ArrivalReporting.java) чи [`DispatchReporting`](src/reporting/DispatchReporting.java)) оскільки ми дотримуємось цього принципу.
    - ### Interface segregation
    - ### Dependency inversion
      Ми можемо замінити інтерфейс [`Place`](src/warehouse/Place.java) на його дочірній клас [`Warehouse`](src/warehouse/Warehouse.java) в методі [`main`](src/Main.java#L20) і навпаки.