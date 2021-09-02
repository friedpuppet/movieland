-- country
insert into movieland.country (id, name) values(1, 'США');
insert into movieland.country (id, name) values(2, 'Франция');
insert into movieland.country (id, name) values(3, 'Великобритания');
insert into movieland.country (id, name) values(4, 'Италия');
insert into movieland.country (id, name) values(5, 'Германия');
insert into movieland.country (id, name) values(6, 'Япония');
insert into movieland.country (id, name) values(7, 'Испания');

-- genre
insert into movieland.genre (id, name) values(1, 'драма');
insert into movieland.genre (id, name) values(2, 'криминал');
insert into movieland.genre (id, name) values(3, 'фэнтези');
insert into movieland.genre (id, name) values(4, 'детектив');
insert into movieland.genre (id, name) values(5, 'мелодрама');
insert into movieland.genre (id, name) values(6, 'биография');
insert into movieland.genre (id, name) values(7, 'комедия');
insert into movieland.genre (id, name) values(8, 'фантастика');
insert into movieland.genre (id, name) values(9, 'боевик');
insert into movieland.genre (id, name) values(10, 'триллер');
insert into movieland.genre (id, name) values(11, 'приключения');
insert into movieland.genre (id, name) values(12, 'аниме');
insert into movieland.genre (id, name) values(13, 'мультфильм');
insert into movieland.genre (id, name) values(14, 'семейный');
insert into movieland.genre (id, name) values(15, 'вестерн');

-- user
insert into movieland.user(id, nickname, email, password)
values(1, 'Anonymous', 'anonymous.anonymous@example.com', CRYPT('paco', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(2, 'Рональд Рейнольдс', 'ronald.reynolds66@example.com', CRYPT('paco', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(3, 'Дарлин Эдвардс', 'darlene.edwards15@example.com', CRYPT('bricks', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(4, 'Габриэль Джексон', 'gabriel.jackson91@example.com', CRYPT('hjkl', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(5, 'Дэрил Брайант', 'daryl.bryant94@example.com', CRYPT('exodus', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(6, 'Нил Паркер', 'neil.parker43@example.com', CRYPT('878787', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(7, 'Трэвис Райт', 'travis.wright36@example.com', CRYPT('smart', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(8, 'Амелия Кэннеди', 'amelia.kennedy58@example.com', CRYPT('beaker', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(9, 'Айда Дэвис', 'ida.davis80@example.com', CRYPT('pepsi1', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(10, 'Джесси Паттерсон', 'jessie.patterson68@example.com', CRYPT('tommy', 'tlas_redloh_eivom'));
insert into movieland.user(id, nickname, email, password)
values(11, 'Деннис Крейг', 'dennis.craig82@example.com', CRYPT('coldbeer', 'tlas_redloh_eivom'));

-- movie
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(1, 'Побег из Шоушенка', 'The Shawshank Redemption', date'1994-01-01', 'Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.', 8.9, 123.45, 'https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(2, 'Зеленая миля', 'The Green Mile', date'1999-01-01', 'Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.', 8.9, 134.67, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(3, 'Форрест Гамп', 'Forrest Gump', date'1994-01-01', 'От лица главного героя Форреста Гампа, слабоумного безобидного человека с благородным и открытым сердцем, рассказывается история его необыкновенной жизни.Фантастическим образом превращается он в известного футболиста, героя войны, преуспевающего бизнесмена. Он становится миллиардером, но остается таким же бесхитростным, глупым и добрым. Форреста ждет постоянный успех во всем, а он любит девочку, с которой дружил в детстве, но взаимность приходит слишком поздно.', 8.6, 200.60, 'https://images-na.ssl-images-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR2,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(4, 'Список Шиндлера', 'Schindler''s List', date'1993-01-01', 'Фильм рассказывает реальную историю загадочного Оскара Шиндлера, члена нацистской партии, преуспевающего фабриканта, спасшего во время Второй мировой войны почти 1200 евреев.', 8.7, 150.50, 'https://images-na.ssl-images-amazon.com/images/M/MV5BNDE4OTMxMTctNmRhYy00NWE2LTg3YzItYTk3M2UwOTU5Njg4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SX140_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(5, '1+1', 'Intouchables', date'2011-01-01', 'Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, — молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений.', 8.3, 120.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxNDA3MDQwNl5BMl5BanBnXkFtZTcwNTU4Mzc1Nw@@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(6, 'Начало', 'Inception', date'2010-01-01', 'Кобб — талантливый вор, лучший из лучших в опасном искусстве извлечения: он крадет ценные секреты из глубин подсознания во время сна, когда человеческий разум наиболее уязвим. Редкие способности Кобба сделали его ценным игроком в привычном к предательству мире промышленного шпионажа, но они же превратили его в извечного беглеца и лишили всего, что он когда-либо любил.', 8.6, 130.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(7, 'Жизнь прекрасна', 'La vita è bella', date'1997-01-01', 'Во время II Мировой войны в Италии в концлагерь были отправлены евреи, отец и его маленький сын. Жена, итальянка, добровольно последовала вслед за ними. В лагере отец сказал сыну, что все происходящее вокруг является очень большой игрой за приз в настоящий танк, который достанется тому мальчику, который сможет не попасться на глаза надзирателям. Он сделал все, чтобы сын поверил в игру и остался жив, прячась в бараке.', 8.2, 145.99, 'https://images-na.ssl-images-amazon.com/images/M/MV5BYmJmM2Q4NmMtYThmNC00ZjRlLWEyZmItZTIwOTBlZDQ3NTQ1XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(8, 'Бойцовский клуб', 'Fight Club', date'1999-01-01', 'Терзаемый хронической бессонницей и отчаянно пытающийся вырваться из мучительно скучной жизни, клерк встречает некоего Тайлера Дардена, харизматического торговца мылом с извращенной философией. Тайлер уверен, что самосовершенствование — удел слабых, а саморазрушение — единственное, ради чего стоит жить.', 8.4, 119.99, 'https://images-na.ssl-images-amazon.com/images/M/MV5BZGY5Y2RjMmItNDg5Yy00NjUwLThjMTEtNDc2OGUzNTBiYmM1XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(9, 'Звёздные войны: Эпизод 4 – Новая надежда', 'Star Wars', date'1977-01-01', 'Татуин. Планета-пустыня. Уже постаревший рыцарь Джедай Оби Ван Кеноби спасает молодого Люка Скайуокера, когда тот пытается отыскать пропавшего дроида. С этого момента Люк осознает свое истинное назначение: он один из рыцарей Джедай. В то время как гражданская война охватила галактику, а войска повстанцев ведут бои против сил злого Императора, к Люку и Оби Вану присоединяется отчаянный пилот-наемник Хан Соло, и в сопровождении двух дроидов, R2D2 и C-3PO, этот необычный отряд отправляется на поиски предводителя повстанцев — принцессы Леи. Героям предстоит отчаянная схватка с устрашающим Дартом Вейдером — правой рукой Императора и его секретным оружием — «Звездой Смерти».', 8.1, 198.98, 'https://images-na.ssl-images-amazon.com/images/M/MV5BYTUwNTdiMzMtNThmNS00ODUzLThlMDMtMTM5Y2JkNWJjOGQ2XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1._SX140_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(10, 'Звёздные войны: Эпизод 5 – Империя наносит ответный удар', 'Star Wars: Episode V - The Empire Strikes Back', date'1980-01-01', 'Борьба за Галактику обостряется в пятом эпизоде космической саги. Войска Императора начинают массированную атаку на повстанцев и их союзников. Хан Соло и принцесса Лейя укрываются в Заоблачном Городе, в котором их и захватывает Дарт Вейдер, в то время как Люк Скайуокер находится на таинственной планете джунглей Дагоба. Там Мастер — джедай Йода обучает молодого рыцаря навыкам обретения Силы. Люк даже не предполагает, как скоро ему придется воспользоваться знаниями старого Мастера: впереди битва с превосходящими силами Императора и смертельный поединок с Дартом Вейдером.', 8.2, 198.98, 'https://images-na.ssl-images-amazon.com/images/M/MV5BYmViY2M2MTYtY2MzOS00YjQ1LWIzYmEtOTBiNjhlMGM0NjZjXkEyXkFqcGdeQXVyNDYyMDk5MTU@._V1._SX140_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(11, 'Унесённые призраками', 'Sen to Chihiro no kamikakushi', date'2001-01-01', 'Маленькая Тихиро вместе с мамой и папой переезжают в новый дом. Заблудившись по дороге, они оказываются в странном пустынном городе, где их ждет великолепный пир. Родители с жадностью набрасываются на еду и к ужасу девочки превращаются в свиней, став пленниками злой колдуньи Юбабы, властительницы таинственного мира древних богов и могущественных духов.', 8.6, 145.90, 'https://images-na.ssl-images-amazon.com/images/M/MV5BOGJjNzZmMmUtMjljNC00ZjU5LWJiODQtZmEzZTU0MjBlNzgxL2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(12, 'Титаник', 'Titanic', date'1997-01-01', 'Молодые влюбленные Джек и Роза находят друг друга в первом и последнем плавании «непотопляемого» Титаника. Они не могли знать, что шикарный лайнер столкнется с айсбергом в холодных водах Северной Атлантики, и их страстная любовь превратится в схватку со смертью…', 7.9, 150.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(13, 'Пролетая над гнездом кукушки', 'One Flew Over the Cuckoo''s Nest', date'1975-01-01', 'Сымитировав помешательство в надежде избежать тюремного заключения, Рэндл Патрик МакМерфи попадает в психиатрическую клинику, где почти безраздельным хозяином является жестокосердная сестра Милдред Рэтчед. МакМерфи поражается тому, что прочие пациенты смирились с существующим положением вещей, а некоторые — даже сознательно пришли в лечебницу, прячась от пугающего внешнего мира. И решается на бунт. В одиночку.', 8.7, 180.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BZjA0OWVhOTAtYWQxNi00YzNhLWI4ZjYtNjFjZTEyYjJlNDVlL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(14, 'Ходячий замок', 'Hauru no ugoku shiro', date'2004-01-01', 'Злая ведьма заточила 18-летнюю Софи в тело старухи. В поисках того, кто поможет ей вернуться к своему облику, Софи знакомится с могущественным волшебником Хаулом и его демоном Кальцифером. Кальцифер должен служить Хаулу по договору, условия которого он не может разглашать. Девушка и демон решают помочь друг другу избавиться от злых чар…', 8.2, 130.50, 'https://images-na.ssl-images-amazon.com/images/M/MV5BZTRhY2QwM2UtNWRlNy00ZWQwLTg3MjktZThmNjQ3NTdjN2IxXkEyXkFqcGdeQXVyMzg2MzE2OTE@._V1._SY209_CR5,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(15, 'Гладиатор', 'Gladiator', date'2000-01-01', 'В великой Римской империи не было военачальника, равного генералу Максимусу. Непобедимые легионы, которыми командовал этот благородный воин, боготворили его и могли последовать за ним даже в ад. Но случилось так, что отважный Максимус, готовый сразиться с любым противником в честном бою, оказался бессилен против вероломных придворных интриг. Генерала предали и приговорили к смерти. Чудом избежав гибели, Максимус становится гладиатором.', 8.6, 175.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMDliMmNhNDEtODUyOS00MjNlLTgxODEtN2U3NzIxMGVkZTA1L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(16, 'Большой куш', 'Snatch', date'2000-01-01', 'Четырехпалый Френки должен был переправить краденый алмаз из Англии в США своему боссу Эви. Но вместо этого герой попадает в эпицентр больших неприятностей. Сделав ставку на подпольном боксерском поединке, Френки попадает в круговорот весьма нежелательных событий. Вокруг героя и его груза разворачивается сложная интрига с участием множества колоритных персонажей лондонского дна — русского гангстера, троих незадачливых грабителей, хитрого боксера и угрюмого громилы грозного мафиози. Каждый норовит в одиночку сорвать Большой Куш.', 8.5, 160.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTA2NDYxOGYtYjU1Mi00Y2QzLTgxMTQtMWI1MGI0ZGQ5MmU4XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1._SY209_CR1,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(17, 'Темный рыцарь', 'The Dark Knight', date'2008-01-01', 'Бэтмен поднимает ставки в войне с криминалом. С помощью лейтенанта Джима Гордона и прокурора Харви Дента он намерен очистить улицы от преступности, отравляющей город. Сотрудничество оказывается эффективным, но скоро они обнаружат себя посреди хаоса, развязанного восходящим криминальным гением, известным испуганным горожанам под именем Джокер.', 8.5, 199.99, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(18, 'Как приручить дракона', 'How to Train Your Dragon', date'2010-01-01', 'Вы узнаете историю подростка Иккинга, которому не слишком близки традиции его героического племени, много лет ведущего войну с драконами. Мир Иккинга переворачивается с ног на голову, когда он неожиданно встречает дракона Беззубика, который поможет ему и другим викингам увидеть привычный мир с совершенно другой стороны…', 8.2, 182.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjA5NDQyMjc2NF5BMl5BanBnXkFtZTcwMjg5ODcyMw@@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(19, 'Молчание ягнят', 'The Silence of the Lambs', date'1990-01-01', 'Психопат похищает и убивает молодых женщин по всему Среднему Западу Америки. ФБР, уверенное в том, что все преступления совершены одним и тем же человеком, поручает агенту Клариссе Старлинг встретиться с заключенным-маньяком, который мог бы объяснить следствию психологические мотивы серийного убийцы и тем самым вывести на его след.', 8.3, 150.50, 'https://images-na.ssl-images-amazon.com/images/M/MV5BNjNhZTk0ZmEtNjJhMi00YzFlLWE1MmEtYzM1M2ZmMGMwMTU4XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1._SY209_CR1,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(20, 'Гран Торино', 'Gran Torino', date'2008-01-01', 'Вышедший на пенсию автомеханик Уолт Ковальски проводит дни, починяя что-то по дому, попивая пиво и раз в месяц заходя к парикмахеру. И хотя последним желанием его недавно почившей жены было совершение им исповеди, Уолту — ожесточившемуся ветерану Корейской войны, всегда держащему свою винтовку наготове, — признаваться в общем-то не в чем. Да и нет того, кому он доверял бы в той полной мере, в какой доверяет своей собаке Дейзи.', 8.1, 100.50, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTk2OTU1Nl5BMl5BanBnXkFtZTcwMDc3NjAwMg@@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(21, 'Хороший, плохой, злой', 'Il buono, il brutto, il cattivo', date'2008-01-01', 'В разгар гражданской войны таинственный стрелок скитается по просторам Дикого Запада. У него нет ни дома, ни друзей, ни компаньонов, пока он не встречает двоих незнакомцев, таких же безжалостных и циничных. По воле судьбы трое мужчин вынуждены объединить свои усилия в поисках украденного золота. Но совместная работа — не самое подходящее занятие для таких отъявленных бандитов, как они. Компаньоны вскоре понимают, что в их дерзком и опасном путешествии по разоренной войной стране самое важное — никому не доверять и держать пистолет наготове, если хочешь остаться в живых.', 8.5, 130.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1._SX140_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(22, 'Укрощение строптивого', 'Il bisbetico domato', date'1980-01-01', 'Категорически не приемлющий женского общества грубоватый фермер вполне счастлив и доволен своей холостяцкой жизнью. Но неожиданно появившаяся в его жизни героиня пытается изменить его взгляды на жизнь и очаровать его. Что же из этого получится…', 7.7, 120.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTc5NTM5OTY0Nl5BMl5BanBnXkFtZTcwNjg1MjcyMQ@@._V1._SY209_CR3,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(23, 'Блеф', 'Bluff storia di truffe e di imbroglioni', date'1976-01-01', 'Белль Дюк имеет старые счеты с Филиппом Бэнгом, который отбывает свой срок за решёткой. Для того чтобы поквитаться с Филиппом, Белль Дюк вступает в сговор с другим аферистом по имени Феликс, чтобы тот организовал побег Филиппа Бенга из тюрьмы. Побег удаётся, но парочка заодно обманывает и Белль Дюк, исчезнув прямо из-под её носа. Выясняется, что и Филипп Бэнг, в свою очередь, не прочь отомстить Белль Дюк. Для этого он задумывает грандиозную мистификацию, сродни покерному блефу…', 7.6, 100.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjk5YmMxMjMtMTlkNi00YTI5LThhYTMtOTk2NmNiNzQwMzI0XkEyXkFqcGdeQXVyMTQ3Njg3MQ@@._V1._SX140_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(24, 'Джанго освобожденный', 'Django Unchained', date'2012-01-01', 'Эксцентричный охотник за головами, также известный как «Дантист», промышляет отстрелом самых опасных преступников. Работенка пыльная, и без надежного помощника ему не обойтись. Но как найти такого и желательно не очень дорогого? Беглый раб по имени Джанго — прекрасная кандидатура. Правда, у нового помощника свои мотивы — кое с чем надо разобраться…', 8.5, 170.00, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMjIyNTQ5NjQ1OV5BMl5BanBnXkFtZTcwODg1MDU4OA@@._V1._SY209_CR0,0,140,209_.jpg', 100);
insert into movieland.movie (id, name_russian, name_native,  year_of_release, description, rating, price, picture_path, votes)
values(25, 'Танцующий с волками', 'Dances with Wolves', date'1990-01-01', 'Действие фильма происходит в США во времена Гражданской войны. Лейтенант американской армии Джон Данбар после ранения в бою просит перевести его на новое место службы ближе к западной границе США. Место его службы отдалённый маленький форт. Непосредственный его командир покончил жизнь самоубийством, а попутчик Данбара погиб в стычке с индейцами после того, как довез героя до места назначения. Людей, знающих, что Данбар остался один в форте и должен выжить в условиях суровой природы, и в соседстве с кажущимися негостеприимными коренными обитателями Северной Америки, просто не осталось. Казалось, он покинут всеми. Постепенно лейтенант осваивается, он ведет записи в дневнике…', 8.0, 120.55, 'https://images-na.ssl-images-amazon.com/images/M/MV5BMTY3OTI5NDczN15BMl5BanBnXkFtZTcwNDA0NDY3Mw@@._V1._SX140_CR0,0,140,209_.jpg', 100);

-- movie_country
insert into movieland.movie_country (movie_id, country_id) values(1, 1);
insert into movieland.movie_country (movie_id, country_id) values(2, 1);
insert into movieland.movie_country (movie_id, country_id) values(3, 1);
insert into movieland.movie_country (movie_id, country_id) values(4, 1);
insert into movieland.movie_country (movie_id, country_id) values(5, 2);
insert into movieland.movie_country (movie_id, country_id) values(6, 1);
insert into movieland.movie_country (movie_id, country_id) values(6, 3);
insert into movieland.movie_country (movie_id, country_id) values(7, 4);
insert into movieland.movie_country (movie_id, country_id) values(8, 1);
insert into movieland.movie_country (movie_id, country_id) values(8, 5);
insert into movieland.movie_country (movie_id, country_id) values(9, 1);
insert into movieland.movie_country (movie_id, country_id) values(10, 1);
insert into movieland.movie_country (movie_id, country_id) values(11, 6);
insert into movieland.movie_country (movie_id, country_id) values(12, 1);
insert into movieland.movie_country (movie_id, country_id) values(13, 1);
insert into movieland.movie_country (movie_id, country_id) values(14, 6);
insert into movieland.movie_country (movie_id, country_id) values(15, 1);
insert into movieland.movie_country (movie_id, country_id) values(15, 3);
insert into movieland.movie_country (movie_id, country_id) values(16, 3);
insert into movieland.movie_country (movie_id, country_id) values(16, 1);
insert into movieland.movie_country (movie_id, country_id) values(17, 1);
insert into movieland.movie_country (movie_id, country_id) values(17, 3);
insert into movieland.movie_country (movie_id, country_id) values(18, 1);
insert into movieland.movie_country (movie_id, country_id) values(19, 1);
insert into movieland.movie_country (movie_id, country_id) values(20, 1);
insert into movieland.movie_country (movie_id, country_id) values(20, 5);
insert into movieland.movie_country (movie_id, country_id) values(21, 4);
insert into movieland.movie_country (movie_id, country_id) values(21, 7);
insert into movieland.movie_country (movie_id, country_id) values(21, 5);
insert into movieland.movie_country (movie_id, country_id) values(21, 1);
insert into movieland.movie_country (movie_id, country_id) values(22, 4);
insert into movieland.movie_country (movie_id, country_id) values(23, 4);
insert into movieland.movie_country (movie_id, country_id) values(24, 1);
insert into movieland.movie_country (movie_id, country_id) values(25, 1);
insert into movieland.movie_country (movie_id, country_id) values(25, 3);

-- movie_genre
insert into movieland.movie_genre(movie_id, genre_id)
values(1, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(1, 2);
insert into movieland.movie_genre(movie_id, genre_id)
values(2, 3);
insert into movieland.movie_genre(movie_id, genre_id)
values(2, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(2, 2);
insert into movieland.movie_genre(movie_id, genre_id)
values(2, 4);
insert into movieland.movie_genre(movie_id, genre_id)
values(3, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(3, 5);
insert into movieland.movie_genre(movie_id, genre_id)
values(4, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(4, 6);
insert into movieland.movie_genre(movie_id, genre_id)
values(5, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(5, 7);
insert into movieland.movie_genre(movie_id, genre_id)
values(5, 6);
insert into movieland.movie_genre(movie_id, genre_id)
values(6, 8);
insert into movieland.movie_genre(movie_id, genre_id)
values(6, 9);
insert into movieland.movie_genre(movie_id, genre_id)
values(6, 10);
insert into movieland.movie_genre(movie_id, genre_id)
values(6, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(6, 4);
insert into movieland.movie_genre(movie_id, genre_id)
values(7, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(7, 5);
insert into movieland.movie_genre(movie_id, genre_id)
values(7, 7);
insert into movieland.movie_genre(movie_id, genre_id)
values(8, 10);
insert into movieland.movie_genre(movie_id, genre_id)
values(8, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(8, 2);
insert into movieland.movie_genre(movie_id, genre_id)
values(9, 8);
insert into movieland.movie_genre(movie_id, genre_id)
values(9, 3);
insert into movieland.movie_genre(movie_id, genre_id)
values(9, 9);
insert into movieland.movie_genre(movie_id, genre_id)
values(9, 11);
insert into movieland.movie_genre(movie_id, genre_id)
values(10, 8);
insert into movieland.movie_genre(movie_id, genre_id)
values(10, 3);
insert into movieland.movie_genre(movie_id, genre_id)
values(10, 9);
insert into movieland.movie_genre(movie_id, genre_id)
values(10, 11);
insert into movieland.movie_genre(movie_id, genre_id)
values(11, 12);
insert into movieland.movie_genre(movie_id, genre_id)
values(11, 13);
insert into movieland.movie_genre(movie_id, genre_id)
values(11, 3);
insert into movieland.movie_genre(movie_id, genre_id)
values(11, 11);
insert into movieland.movie_genre(movie_id, genre_id)
values(11, 14);
insert into movieland.movie_genre(movie_id, genre_id)
values(12, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(12, 5);
insert into movieland.movie_genre(movie_id, genre_id)
values(13, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(14, 12);
insert into movieland.movie_genre(movie_id, genre_id)
values(14, 13);
insert into movieland.movie_genre(movie_id, genre_id)
values(14, 3);
insert into movieland.movie_genre(movie_id, genre_id)
values(14, 11);
insert into movieland.movie_genre(movie_id, genre_id)
values(15, 9);
insert into movieland.movie_genre(movie_id, genre_id)
values(15, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(16, 2);
insert into movieland.movie_genre(movie_id, genre_id)
values(16, 7);
insert into movieland.movie_genre(movie_id, genre_id)
values(17, 8);
insert into movieland.movie_genre(movie_id, genre_id)
values(17, 9);
insert into movieland.movie_genre(movie_id, genre_id)
values(17, 10);
insert into movieland.movie_genre(movie_id, genre_id)
values(17, 2);
insert into movieland.movie_genre(movie_id, genre_id)
values(17, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(18, 13);
insert into movieland.movie_genre(movie_id, genre_id)
values(18, 3);
insert into movieland.movie_genre(movie_id, genre_id)
values(18, 7);
insert into movieland.movie_genre(movie_id, genre_id)
values(18, 11);
insert into movieland.movie_genre(movie_id, genre_id)
values(18, 14);
insert into movieland.movie_genre(movie_id, genre_id)
values(19, 10);
insert into movieland.movie_genre(movie_id, genre_id)
values(19, 2);
insert into movieland.movie_genre(movie_id, genre_id)
values(19, 4);
insert into movieland.movie_genre(movie_id, genre_id)
values(19, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(20, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(21, 15);
insert into movieland.movie_genre(movie_id, genre_id)
values(22, 7);
insert into movieland.movie_genre(movie_id, genre_id)
values(23, 7);
insert into movieland.movie_genre(movie_id, genre_id)
values(23, 2);
insert into movieland.movie_genre(movie_id, genre_id)
values(24, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(24, 15);
insert into movieland.movie_genre(movie_id, genre_id)
values(24, 11);
insert into movieland.movie_genre(movie_id, genre_id)
values(24, 7);
insert into movieland.movie_genre(movie_id, genre_id)
values(25, 1);
insert into movieland.movie_genre(movie_id, genre_id)
values(25, 11);
insert into movieland.movie_genre(movie_id, genre_id)
values(25, 15);

-- rating
insert into movieland.rating(movie_id, user_id, rating) values(1, 1, 8.5);
insert into movieland.rating(movie_id, user_id, rating) values(5, 2, 8.5);
insert into movieland.rating(movie_id, user_id, rating) values(6, 3, 9.5);
insert into movieland.rating(movie_id, user_id, rating) values(20, 3, 8.5);
insert into movieland.rating(movie_id, user_id, rating) values(2, 4, 9.0);
insert into movieland.rating(movie_id, user_id, rating) values(2, 2, 9.4);
insert into movieland.rating(movie_id, user_id, rating) values(1, 5, 8.5);
insert into movieland.rating(movie_id, user_id, rating) values(5, 1, 7.4);
insert into movieland.rating(movie_id, user_id, rating) values(7, 11, 8.9);
insert into movieland.rating(movie_id, user_id, rating) values(12, 6, 10.0);
insert into movieland.rating(movie_id, user_id, rating) values(14, 6, 8.5);
insert into movieland.rating(movie_id, user_id, rating) values(13, 6, 7.5);
insert into movieland.rating(movie_id, user_id, rating) values(12, 7, 8.9);
insert into movieland.rating(movie_id, user_id, rating) values(19, 1, 8.5);
insert into movieland.rating(movie_id, user_id, rating) values(17, 2, 8.1);


-- review
insert into movieland.review(id, movie_id, user_id, description)
values(1, 1, 3, 'Гениальное кино! Смотришь и думаешь «Так не бывает!», но позже понимаешь, что только так и должно быть. Начинаешь заново осмысливать значение фразы, которую постоянно используешь в своей жизни, «Надежда умирает последней». Ведь если ты не надеешься, то все в твоей жизни гаснет, не остается смысла. Фильм наполнен бесконечным числом правильных афоризмов. Я уверена, что буду пересматривать его сотни раз.');
insert into movieland.review(id, movie_id, user_id, description)
values(2, 1, 4, 'Кино это является, безусловно, «со знаком качества». Что же до первого места в рейтинге, то, думаю, здесь имело место быть выставление «десяточек» от большинства зрителей вкупе с раздутыми восторженными откликами кинокритиков. Фильм атмосферный. Он драматичный. И, конечно, заслуживает того, чтобы находиться довольно высоко в мировом кинематографе.');
insert into movieland.review(id, movie_id, user_id, description)
values(3, 2, 2, 'Перестал удивляться тому, что этот фильм занимает сплошь первые места во всевозможных кино рейтингах. Особенно я люблю когда при экранизации литературного произведение из него в силу специфики кинематографа исчезает ирония и появляется некий сверхреализм, обязанный удерживать зрителя у экрана каждую отдельно взятую секунду.');
insert into movieland.review(id, movie_id, user_id, description)
values(4, 3, 6, 'Много еще можно сказать об этом шедевре. И то, что он учит верить, и то, чтобы никогда не сдаваться… Но самый главный девиз я увидел вот в этой фразе: «Занимайся жизнью, или занимайся смертью».');
insert into movieland.review(id, movie_id, user_id, description)
values(5, 4, 7, 'Очень хороший фильм, необычный сюжет, я бы даже сказала непредсказуемый. Такие фильмы уже стали редкостью.');
insert into movieland.review(id, movie_id, user_id, description)
values(6, 5, 10, 'У меня не найдётся слов, чтобы описать этот фильм. Не хочется быть банальной и говорить какой он отличный, непредсказуемый и т. д., но от этого никуда не деться к сожалению — ведь он ШЕДЕВРАЛЬНЫЙ!');
insert into movieland.review(id, movie_id, user_id, description)
values(7, 5, 8, 'Скажу сразу — фильм выглядел многообещающе, даже если не брать в расчет что он находился в топе-250 лучших фильмов. Известные голливудские актеры на главных ролях. Но нет в этом фильме должной атмосферы. Нет такого чувства что вот сейчас случится что-то страшное. Что герои попали в ситуацию из которой не смогут выбраться. В общем, не понравилось.');
insert into movieland.review(id, movie_id, user_id, description)
values(8, 7, 4, '«Все должно быть супер! Супер! Су-пер!» И это именно супер, ну слов других не подберешь.');
insert into movieland.review(id, movie_id, user_id, description)
values(9, 8, 11, 'Фильм очень красивый. Не во всем, конечно, но яркие персонажи и костюмы — это уже кое-что.');
insert into movieland.review(id, movie_id, user_id, description)
values(10, 18, 4, 'Этот фильм из разряда тех, что могут обеспечить хороший отдых и приподнятое настроение за счёт своей лёгкости, совсем непошлого юмора, умеренной дозы напряжения, динамики нужных скоростей.');
insert into movieland.review(id, movie_id, user_id, description)
values(11, 18, 6, 'Назначается Киношедевром среди развлекательных фильмов.');
insert into movieland.review(id, movie_id, user_id, description)
values(12, 15, 8, 'Данный кинофильм — нестареющая классика мирового кинематографа, который можно пересматривать до бесконечности и, что удивительно, он не может надоесть.');
insert into movieland.review(id, movie_id, user_id, description)
values(13, 17, 5, 'Рекомендую смотреть всем и не обращать внимания на надоевшее уже спасение целого мира одним человеком.');
insert into movieland.review(id, movie_id, user_id, description)
values(14, 16, 5, 'Удивлен. Никто не отозвался плохо? Неужели было создано произведение искусства, которое нравится всем, и которое совершенно? Нет. Может, я один такой? Фильм не вызывает во мне никаких эмоций. Неплохая сказочка. Замечательная наивная атмосфера. Местами есть забавные шутки. И, как мне показалось, этот фильм — своего рода стёб над другими боевиками. При этом превосходящий многие боевики.');
insert into movieland.review(id, movie_id, user_id, description)
values(15, 11, 11, 'Необыкновенно позитивный фильм. Его можно пересматривать много раз для поднятия настроения, находя много смешных, незаметных на первый взгляд моментов.');
insert into movieland.review(id, movie_id, user_id, description)
values(16, 9, 8, 'Легендарный. Культовый. Бессмертный. Три слова. Всего лишь три. А сколько же они выражают неподдельных эмоций и радостных впечатлений по отношению к очередному любимому и уважаемому фильму из минувшего в лету детства? Много. Слишком много. И описать эти сердечные и гарцующие в здравом рассудке чувства обыкновенными строчными предложениями иногда не представляется возможным.');
insert into movieland.review(id, movie_id, user_id, description)
values(17, 16, 7, 'Приятного просмотра для всех, кто не видел ещё этого шедевра больше впечатлений для тех, кто пересматривает в надцатый раз. =)');
insert into movieland.review(id, movie_id, user_id, description)
values(18, 16, 6, 'Это один из любимых моих фильмов с самого детства. Я видела его столько раз, что знаю практически наизусть. И могу сказать с уверенностью, что посмотрю еще не один раз.');
insert into movieland.review(id, movie_id, user_id, description)
values(19, 19, 4, 'Фильм, безусловно, посмотрела уже большая часть населения, которая хоть каким-то образом имеет отношение к кинематографу. Я считаю, что фильм можно пересмотреть еще не один раз.');
insert into movieland.review(id, movie_id, user_id, description)
values(20, 18, 9, 'Фильм продуман до мельчайших деталей. Идеальный фильм для улучшения настроения, единственный в своем роде. Обязателен к просмотру!');
insert into movieland.review(id, movie_id, user_id, description)
values(21, 23, 6, 'Фильм потрясающий, в нем хватает абсолютно всего: и драк, и музыки, и юмора, и любви.');
insert into movieland.review(id, movie_id, user_id, description)
values(22, 20, 2, 'У фильма есть свои мелкие недостатки  и неточности, но многочисленные достоинства в несколько раз перевешивают. Много вдохновляющего креатива!');
insert into movieland.review(id, movie_id, user_id, description)
values(23, 19, 3, 'Хоть и не по возрасту мне заводить скрипучую пластинку с мелодией «Раньше и деревья были выше, и трава зеленее…», а хочется. Выражать свою любовь к настолько близкому произведению крайне сложно.');
insert into movieland.review(id, movie_id, user_id, description)
values(24, 23, 9, 'Вердикт: прекрасная, нестареющая классика, которая рекомендована мною для всех.');
insert into movieland.review(id, movie_id, user_id, description)
values(25, 21, 5, 'Для воскресного вечернего просмотра подходит по всем критериям.');
insert into movieland.review(id, movie_id, user_id, description)
values(26, 22, 6, 'Хороший и по-настоящему интересный фильм, с хорошим сюжетом и неплохим музыкальным сопровождением. Всем советую к просмотру.');
insert into movieland.review(id, movie_id, user_id, description)
values(27, 24, 7, 'Полагаю, этот фильм должен быть в коллекции каждого уважающего себя киномана.');
insert into movieland.review(id, movie_id, user_id, description)
values(28, 25, 8, 'Нетленный шедевр мирового кинематографа, который можно пересматривать десятки раз и получать все такой — же, извините за выражение, кайф от просмотра. Минусы у фильма, конечно, есть, но черт возьми. Их просто не хочется замечать! Ты настолько поглощен просмотром фильма, что просто не хочется придираться к разным мелочам.');
insert into movieland.review(id, movie_id, user_id, description)
values(29, 24, 9, 'Фильм только выигрывает от частого просмотра и всегда поднимает мне настроение (наряду с драмой, тут еще и тонкий юмор).');
insert into movieland.review(id, movie_id, user_id, description)
values(30, 22, 10, 'Конечно, бесспорно культовый фильм, не реалистичный, наивный, где то глупый, но такой же увлекательный и удивительный, как и много лет назад');
insert into movieland.review(id, movie_id, user_id, description)
values(31, 12, 10, 'В итоге мы имеем отличный представитель своего жанра, который прошёл проверку временем и до сих пор отлично смотрится, несмотря на классический сюжет');
insert into movieland.review(id, movie_id, user_id, description)
values(32, 13, 11, 'Скажу только одно — как я жалею, что не посмотрела его раньше!');
