# INSERT INTO categories (/*category_id,*/ category_name) VALUE (/*1,*/ 'Food');
# INSERT INTO categories (/*category_id,*/ category_name) VALUE (/*2,*/'Clothes');
# INSERT INTO categories (/*category_id,*/ category_name) VALUE (/*3,*/ 'Electronics');
# INSERT INTO categories (/*category_id,*/ category_name) VALUE (/*4,*/ 'AGD');
# INSERT INTO categories (/*category_id,*/ category_name) VALUE (/*5,*/ 'Books');
# INSERT INTO categories (/*category_id,*/ category_name) VALUE (/*6,*/ 'Car');
# INSERT INTO categories (/*category_id,*/  category_name) VALUE (/*7,*/ 'Bike');

INSERT INTO categories (category_id, category_name) VALUE (1, 'Food');
INSERT INTO categories (category_id, category_name) VALUE (2, 'Clothes');
INSERT INTO categories (category_id, category_name) VALUE (3, 'Electronics');
INSERT INTO categories (category_id, category_name) VALUE (4, 'AGD');
INSERT INTO categories (category_id, category_name) VALUE (5, 'Books');
INSERT INTO categories (category_id, category_name) VALUE (6, 'Car');
INSERT INTO categories (category_id, category_name) VALUE (7, 'Bike')

INSERT INTO products (product_id, product_price, product_stock_quantity, product_description, product_image, product_name, product_type, author_id, category_id)
VALUE (1, 15.50, 5, 'produkt o dobrym smaku', 'gooogle.com/pyzki-z-nadzieniem', 'pyzy', 'na wagę', 1, 1);

INSERT INTO order_lines (order_line_id, order_line_number_of_products, order_line_product_price, product_id)
VALUE (1, 3, 21, 1);

INSERT INTO baskets (order_line_id, basket_id, user_account_id)
VALUE (1, 1, 1);


INSERT INTO orders (order_creation_date, order_id, order_order_client, order_total_price, order_delivery_address, order_order_status)
VALUE (12.02, 1, 2, 12.50, 'Piastowska 15, Warszawa', 'delivered');

INSERT INTO roles (role_id, role_name)
VALUE (1, 'Jan');

INSERT INTO user_accounts (role_id, order_id, user_account_id, user_account_address, user_account_avatar, user_account_chanel_preferences, user_account_city, user_account_login, user_account_password)
VALUE (1, 1, 1, 'Bukowa 2/31, Zakopane', 'gooogle.com/lion', 'cosmetics', 'Zakopane', 'lion123', 'roar321');