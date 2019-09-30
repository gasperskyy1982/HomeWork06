<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
			  </div>
            
				<div id="sidebar">
					<table border=1>
                    <tr>
                    <td width="252" align="left">
                    <font color=white>
                    Вы авторизировались как ${user.name} <br />
                    В вашей корзине ${number} товаров.
                    </font>
                    </td>
                    </tr>
                    </table>
                    <h2>Боковое меню</h2>
					<ul>
						<li><a href="./products?category=1">Категория 1</a></li>
						<li><a href="./products?category=2">Категория 2</a></li>
						<li><a href="./products?category=3">Категория 3</a></li>
						<li><a href="./register">Регистрация</a></li>
						<li><a href="./auth">Вход</a></li>
						<li><a href="./cart">Корзина</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="footer">
	<p>Copyright (c) by </p>
</div>
<!-- end #footer -->
</body>
</html>
