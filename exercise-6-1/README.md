# Exercise 6-1

Create an application with the following features:

1. Display a list of presidents, use sample data listed below.
2. When the president name is tapped, a new activity shows up that displays the name of the president, start and end dates of duty and small description of the president selected.
3. Create a President class which represent the president data and Singleton to hold the President list in your application.
4. Add the president of your home country too.

### Sample data to use

```java
// Construct the data source
presidents = new ArrayList<President>();
presidents.add(new President("Stahlberg, Kaarlo Juho", 1919, 1925, "Eka presidentti"));
presidents.add(new President("Relander, Lauri Kristian", 1925, 1931, "Reissulasse"));
presidents.add(new President("Svinhufvud, Pehr, Evind", 1931, 1937, "Ukko-Pekka"));
presidents.add(new President("Kallio, Kyosti", 1937, 1940, "Neljas presidentti"));
presidents.add(new President("Ryti, Risto Heikki", 1940, 1944, "Nuorena Kustu Kalliokangas"));
presidents.add(new President("Mannerheim, Carl Gustav", 1944, 1946, "Marski"));
presidents.add(new President("Paasikivi, Juho Kusti", 1946, 1956, "Äkäinen ukko"));
presidents.add(new President("Kekkonen, Urho Kaleva", 1956, 1982, "Pelimies"));
presidents.add(new President("Koivisto, Mauno Henrik", 1982, 1994, "Manu"));
presidents.add(new President("Ahtisaari, Martti Oiva", 1994, 2000, "Mahtisaari"));
presidents.add(new President("Halonen, Tarja Kaarina", 2000, 2012, "Eka naispressa"));
presidents.add(new President("Niinistö, Sauli Väinämö", 2012, 2024, "Owner of Lennu, the First Dog"));
```

### Expected layout

![Exercise 6-1 expected layout - Main activity](../assets/exercise-6-1-layout-1.png)
![Exercise 6-1 expected layout - President activity](../assets/exercise-6-1-layout-2.png)

### Useful resources

- [ListView](https://developer.android.com/reference/android/widget/ListView)
- [Using an ArrayAdapter with ListView](https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
- [Singleton pattern](https://en.wikipedia.org/wiki/Singleton_pattern)
