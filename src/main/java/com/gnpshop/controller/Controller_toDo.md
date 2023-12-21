# Funkcjonalności

## Funkcjonalności admina
1. Dodawanie kategorii
   * nazwa kategorii
   * id rodzica
2. Przegląd drzewa kategorii
   * wyszukiwanie kategorii
   * możliwość przeciągania kategorii (zmiany położenia)
3. Dodawanie produktu
   * nazwa
   * opis
   * url obrazka
   * stan magazynowy
   * cena
   * typ produktu (dropdown)
   * kategoria (dropdown)
   * autor (dropdown)
4. Lista produktów
   * lista wszystkich dodanych produktów z wypisaniem ich danych
   * przycisk do przejścia na edycję danego produktu
   * wyszukiwanie produktów

## Funkcjonalności użytkownika
1) Rejestracja użytkownika
   * wpisywanie danych do pól formularza + walidacja tych pól
2) Logowanie 
   * możliwość zalogowania się użytkownika (po uprzedniej rejestracji)
   * możliwość wylogowania użytkownika
3) Widget pogody
   * wyświetlanie pogody na podstawie miasta aktualnie zalogowanego użytkownika
4) lista produktów
   * możliwe jest wyświetlanie produktów jako lista lub jako grid
   * wyszukiwanie produktów
   * dodawanie produktu do koszyka
5) Tabela z produktami (działająca ajaxowo na zapytaniu GET i wstawiająca parametry do urla)¶
   * wyświetlanie produktów w tablicy z paginacją (wybór liczby produktów na stronie)
   * sortowanie produktów w tabeli
   * ajaxowe wyszukiwanie produktów
   * dodawanie produktów do koszyka
6) Koszyk 
   * wyświetlanie produktów dodanych do koszyka
   * możliwość zamówienia produktów z koszyka -> prowadzi na statyczną stronę z podziękowaniem oraz zmniejsza stan produktów
7) Zadania dodatkowe i rozszerzenia
   * możliwość edycji konta użytkownika (danych)
   * przegląd zamówień użytkownika (z poziomu usera, jak i admina)
   * dodawanie autora w panelu admina
8) Dodatkowe wymagania
   * należy zadbać o estetyczny i funkcjonalny sposób prezentowania danych 
   * dane pobierane od użytkowników powinny być wstępnie walidowane