# myWords

Project iSA-JJDD4 made by emememsy


Hej,

Marcin zauważył, że po zrobieniu dwóch kontenerów przestały działać polskie znaki oraz, że przestał działać upload pliku.
Nadal możemy usuwać wszystko z bazy i przywracać jej pierwotny stan, ale nie da się wrzucić kolejnego pliku.
Dostajemy wtedy internal server error, który nie pojawia się w żadnych logach (wildfly też).

Piotrek spędził z nami 2 godziny próbując to rozwiązać (jego próby dojścia do błędu lub chociaż wygenerowania logów
znajdują się w branchu: docker-debug-mysql-upload

W tej chwili projekt nawet się nie buduje i pokazuje hibernate error. Mamy wrażenie, że jednak nie mamy
prawidłowo skonfigurowanego połączenia z bazą danych. To co zauważył Piotrek, to że połączenie z bazą danych w pliku web.xml i persistence.xml nie było spójne (próbowaliśmy to ujednolicić, w jednym miescu było 0.0.0.0:3306/mywords a w innym db:3306/mywords. 

Jeżeli satrtujemy aplikację na lokalnym wildfly i tylko bazę mamy w kontenerze to wszystko działa: mamy polskie znaki i działa upload pliku - również na tym branchu do "debudowania". 
Ten sam war wystartowany w 2 kontenerach już nie działa. Stąd podejrzenie, że to nie problem z kodem tylko z setupem kontenetów dockerowych. 

Mieliśmy jednocześnie odpaloną appkę w 2 konfiguracjach z tego samego brancha - więc wyeliminowaliśmy hipotezę, że jakieś zmiany zrobiliśmy przypadkiem w kodzie a cała aplikacja przestała działać. 

Teraz to już sporo namieszaliśmy na tym branchu ale na developie jest wersja z dzisiaj, możesz też zerknąć na tamten kod (dockery nie działają ale projekt się buduje).

Dzięki!
