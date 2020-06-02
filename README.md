# Lab10
## Задание  
 Добавить в приложение фильтры, которые выводят либо всех студентов (уроки), либо только присутствующих, либо только отсутствующих.  
## Выполнение

- Создал класс пепечислений для фильтра списка студентов:  
![1](https://cdn.discordapp.com/attachments/465020961482342411/715975232183205899/unknown.png)

- В State добавил идентификатор для фильтра filter:  
![2](https://cdn.discordapp.com/attachments/465020961482342411/717001156248993792/unknown.png)  

- В redux acions добавил действие SetDisplayFilter для фильтра отображения студентов:  
![3](https://cdn.discordapp.com/attachments/465020961482342411/715976822327738408/unknown.png)

- В reducers добавил функцию SetFilter для включения фильтра в состояние State:  
![4](https://cdn.discordapp.com/attachments/465020961482342411/717001275467759637/unknown.png)  

- Создал контейнер для списка студентов через компонент высшего порядка и котнейнер для списка студентов:  
![5](https://cdn.discordapp.com/attachments/465020961482342411/717362211093348453/unknown.png)  
![6](https://cdn.discordapp.com/attachments/465020961482342411/717362292366377111/unknown.png)  

- Создал контейнеры для компонентов из списков студентов и занятий:  
![7](https://cdn.discordapp.com/attachments/465020961482342411/717011702771744818/unknown.png)  
![8](https://cdn.discordapp.com/attachments/465020961482342411/717011660262342666/unknown.png)

- Здесь же создал функции studetToDisplay и lessonPresent для сортировки списков:  
![9](https://cdn.discordapp.com/attachments/465020961482342411/717011744895270972/unknown.png)  
![10](https://cdn.discordapp.com/attachments/465020961482342411/717011779171123272/unknown.png)

- Создал контейнеры для Editor-ов списков:  
![11](https://cdn.discordapp.com/attachments/465020961482342411/717253818282147880/unknown.png)

- Создал класс FilterButtons для дальнейшей связи кнопок с фильтрами:  
![12](https://cdn.discordapp.com/attachments/465020961482342411/717258132761608252/unknown.png)

- Создал контейнер для обращения к фильтрам:  
![13](https://cdn.discordapp.com/attachments/465020961482342411/717011972343988325/unknown.png)

- Создал компонент showFButtons для отрисовки кнопок:  
![14](https://cdn.discordapp.com/attachments/465020961482342411/717258175354765322/unknown.png)

- Передал контейнеры списков в компонент App под соответствующими путями:  
![15](https://cdn.discordapp.com/attachments/465020961482342411/717258398650859520/unknown.png)  

- Передал контейнеры компонентов из списков в констукции rebderObject, для отображения списков студентов внутри занятий, и наоборот:  
![16](https://cdn.discordapp.com/attachments/465020961482342411/717258448689037322/unknown.png)

- Передал контейнеры для изменения элементов списков внутри renderObject:  
![17](https://cdn.discordapp.com/attachments/465020961482342411/717258494625185792/unknown.png)  

- Создал контейнер для обращения к компоненту построения приложения:  
![18](https://cdn.discordapp.com/attachments/465020961482342411/717280180216791090/unknown.png) 

- Скоректировал функцию main, для работы с appContainer:  
![19](https://cdn.discordapp.com/attachments/465020961482342411/717258620286533763/unknown.png)

- Запсук приложения:  
![20](https://cdn.discordapp.com/attachments/465020961482342411/717337905386881024/unknown.png)

- Кликнул по надписи Lessons:  
![21](https://cdn.discordapp.com/attachments/465020961482342411/717337959904444486/unknown.png)

- Кликнул по Add:  
![22](https://cdn.discordapp.com/attachments/465020961482342411/717338028376588298/unknown.png)

- Кдикнул по Edit напротив new lesson и ввел новое название - Mathimatic:  
![23](https://cdn.discordapp.com/attachments/465020961482342411/717338197050523698/unknown.png)

- После клика по кнопке Save:  
![24](https://cdn.discordapp.com/attachments/465020961482342411/717338253614776380/unknown.png)

- Кликнул по Delete напротив Lecture:  
![25](https://cdn.discordapp.com/attachments/465020961482342411/717362835319160922/unknown.png)

- Кликнул по надписи Students:  
![26](https://cdn.discordapp.com/attachments/465020961482342411/717362886061719613/unknown.png)

- Кликнул по надписи Add:  
![27](https://cdn.discordapp.com/attachments/465020961482342411/717362929330159676/unknown.png)

- Кликнул по надписи Edit напротив new student и ввел Pitter Parker:  
![28](https://cdn.discordapp.com/attachments/465020961482342411/717363063476715651/unknown.png)

- Кликнул по кнопке Save:  
![29](https://cdn.discordapp.com/attachments/465020961482342411/717363247270985738/unknown.png)

- Кликнул по кнопке Delete напротив Howard Wolowitz:  
![30](https://cdn.discordapp.com/attachments/465020961482342411/717363292896624640/unknown.png)
