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
![9](https://cdn.discordapp.com/attachments/465020961482342411/717011972343988325/unknown.png)

- Создал компонент showFButtons для отрисовки кнопок:  
![14](https://cdn.discordapp.com/attachments/465020961482342411/717258175354765322/unknown.png)

- Передал контейнеры списков в компонент App под соответствующими путями:  
![15](https://cdn.discordapp.com/attachments/465020961482342411/717258398650859520/unknown.png)  

- Передал контейнеры компонентов из списков в констукции rebderObject, для отображения списков студентов внутри занятий, и наоборот:  
![16](https://cdn.discordapp.com/attachments/465020961482342411/717258448689037322/unknown.png)

- Передал контейнеры для изменения элементов списков внутри renderObject:  
![17](https://cdn.discordapp.com/attachments/465020961482342411/717258494625185792/unknown.png)  

- Создал контейнер для обращения к компоненту построения приложения:  
![](https://cdn.discordapp.com/attachments/465020961482342411/717280180216791090/unknown.png) 

- Скоректировал функцию main, для работы с appContainer:  
![18](https://cdn.discordapp.com/attachments/465020961482342411/717258620286533763/unknown.png)
