INSERT INTO country (
    country_id,
    coordinates,
    country_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             1,
             '',
             'Монгол',
             0,
             NOW(),
             0,
             NOW()
         );


INSERT INTO province (
    province_id,
    coordinates,
    province_name,
    country_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             1,
             '',
             'Улаанбаатар',
             1,
             0,
             NOW(),
             0,
             NOW()
         );



INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             1,
             '',
             'Баянзүрх',
             1,
             0,
             NOW(),
             0,
             NOW()
         );



INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             2,
             '',
             'Сонгинохайрхан',
             1,
             0,
             NOW(),
             0,
             NOW()
         );



INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             3,
             '',
             'Баянгол',
             1,
             0,
             NOW(),
             0,
             NOW()
         );


INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             4,
             '',
             'Хан-Уул',
             1,
             0,
             NOW(),
             0,
             NOW()
         );



INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             5,
             '',
             'Чингэлтэй',
             1,
             0,
             NOW(),
             0,
             NOW()
         );

INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             6,
             '',
             'Сүхбаатар',
             1,
             0,
             NOW(),
             0,
             NOW()
         );

INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             7,
             '',
             'Налайх',
             1,
             0,
             NOW(),
             0,
             NOW()
         );

INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             8,
             '',
             'Багануур',
             1,
             0,
             NOW(),
             0,
             NOW()
         );

INSERT INTO district (
    district_id,
    coordinates,
    district_name,
    province_id,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime
) VALUES (
             9,
             '',
             'Багахангай',
             1,
             0,
             NOW(),
             0,
             NOW()
         );


INSERT INTO place (
    place_id,
    place_name,
    description,
    address,
    latitude,
    longitude,
    floor_number,
    created_datetime,
    created_by,
    modified_datetime,
    modified_by,
    district_id
) VALUES (
             1,
             'MaxMall',
             'Баруун 4 замын уулзвар дахь худалдааны төв',
             'Баруун 4 зам',
             47.91541802528958,
             106.89186375713771,
             5,
             NOW(),
             0,
             NOW(),
             0,
             3
         );

INSERT INTO place (
    place_id,
    place_name,
    description,
    address,
    latitude,
    longitude,
    floor_number,
    created_datetime,
    created_by,
    modified_datetime,
    modified_by,
    district_id
) VALUES (
             2,
             'Улсын их дэлгүүр',
             'Монгол улсын анхны их дэлгүүр',
             'CHD - 3 khoroo, Ulaanbaatar 15172',
             47.91703280186287,
             106.9063869938821,
             10,
             NOW(),
             0,
             NOW(),
             0,
             7
         );



INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             1,
             '2025-12-07 18:24:22.751',
             '/uploads/place/2025-12-07/c6bab7da-605b-4372-b389-aaa8b2ca261f_maxmall.jpg',
             'maxmall.jpg',
             'place'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             2,
             '2025-12-07 18:24:37.863',
             '/uploads/place/2025-12-07/aaf96b55-bdf6-44ac-bf2a-04c779c4bd6c_ihdelguur.jpeg',
             'ihdelguur.jpeg',
             'place'
         );



INSERT INTO place_media (
    place_place_id,
    media_media_id,
    created_datetime
) VALUES (
             1,
             1,
             NOW()
         );

INSERT INTO place_media (
    place_place_id,
    media_media_id,
    created_datetime
) VALUES (
             2,
             2,
             NOW()
         );


INSERT INTO users (
    user_id,
    created_by,
    created_datetime,
    email,
    first_name,
    last_name,
    modified_by,
    modified_datetime,
    "password",
    phone_number,
    profile_picture,
    "role",
    username
) VALUES (
             1,
             0,
             '2025-12-07 18:31:00.865',
             'altai@gmail.com',
             'Altai',
             'Gantumur',
             0,
             '2025-12-07 18:31:00.865',
             '$2a$10$pM359LNpe4Vjmyxffmr5tOVECtd1yNsQDYYCEiILxp3MQHjHCIY6K',
             '+97690292709',
             NULL,
             'ADMIN',
             'altai'
         );


INSERT INTO users (
    user_id,
    created_by,
    created_datetime,
    email,
    first_name,
    last_name,
    modified_by,
    modified_datetime,
    "password",
    phone_number,
    profile_picture,
    "role",
    username
) VALUES (
             2,
             0,
             '2025-12-07 18:31:37.924',
             'goku@gmail.com',
             'Goku',
             'Son',
             0,
             '2025-12-07 18:31:37.924',
             '$2a$10$9YxQmWd128z2wrhuEJue8.2/J/wEIImVu3JPQA.42rIR841gYbVPC',
             '+86123123123',
             NULL,
             'USER',
             'goku'
         );

INSERT INTO users (
    user_id,
    created_by,
    created_datetime,
    email,
    first_name,
    last_name,
    modified_by,
    modified_datetime,
    "password",
    phone_number,
    profile_picture,
    "role",
    username
) VALUES (
             3,
             0,
             '2025-12-07 18:32:09.672',
             'naruto@gmail.com',
             'Naruto',
             'Uzumaki',
             0,
             '2025-12-07 18:32:09.672',
             '$2a$10$v2psWPFuKW3hQWvL1KHzeOTaBAF0cCdLf69CZje2gUK7SnIrlcCOW',
             '+123123123',
             NULL,
             'USER',
             'naruto'
         );


-- Хоолны газар
-- Нийтийн үзвэр
-- Буудал
-- Чөлөөт цаг
-- Гоо сайхан & эрүүл мэнд
-- Кареоке
-- Спорт / Фитнесс
-- Массаж

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             3,
             '2025-12-07 20:33:27.986',
             '/uploads/category/2025-12-07/7adf81f0-dca5-43ab-93bf-fad2a9d9c8bb_food.png',
             'food.png',
             'category'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             4,
             '2025-12-07 20:33:41.751',
             '/uploads/category/2025-12-07/5b5b3347-ff1f-4593-b0a2-d7cfc8c31068_attraction.png',
             'attraction.png',
             'category'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             5,
             '2025-12-07 20:33:50.312',
             '/uploads/category/2025-12-07/6eb0e7df-5857-4086-a9d4-0047767ef6de_hotel.png',
             'hotel.png',
             'category'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             6,
             '2025-12-07 20:33:58.782',
             '/uploads/category/2025-12-07/8590e387-b5b8-498f-a503-3b373631176a_fun.png',
             'fun.png',
             'category'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             7,
             '2025-12-07 20:34:06.513',
             '/uploads/category/2025-12-07/8a3ac255-d5d8-42c0-89ad-d391723d61cd_beauty.png',
             'beauty.png',
             'category'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             8,
             '2025-12-07 20:34:14.464',
             '/uploads/category/2025-12-07/a619afef-f58f-4c5c-943a-635e13923c86_kareoke.png',
             'kareoke.png',
             'category'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             9,
             '2025-12-07 20:34:22.264',
             '/uploads/category/2025-12-07/df732f5c-862d-4a86-b243-7a0e47b2d681_sport.png',
             'sport.png',
             'category'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             10,
             '2025-12-07 20:34:30.169',
             '/uploads/category/2025-12-07/2ecadba9-38ed-454f-988e-c2cb0364de42_massage.png',
             'massage.png',
             'category'
         );


INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             1,
             'Хоолны газар',
             'Хоолны газар',
             0,
             NOW(),
             0,
             NOW(),
             3
         );

INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             2,
             'Нийтийн үзвэр',
             'Нийтийн үзвэр',
             0,
             NOW(),
             0,
             NOW(),
             4
         );

INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             3,
             'Буудал',
             'Буудал',
             0,
             NOW(),
             0,
             NOW(),
             5
         );

INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             4,
             'Чөлөөт цаг',
             'Чөлөөт цаг',
             0,
             NOW(),
             0,
             NOW(),
             6
         );


INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             5,
             'Гоо сайхан & эрүүл мэнд',
             'Гоо сайхан & эрүүл мэнд',
             0,
             NOW(),
             0,
             NOW(),
             7
         );

INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             6,
             'Кареоке',
             'Кареоке',
             0,
             NOW(),
             0,
             NOW(),
             8
         );

INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             7,
             'Спорт / Фитнесс',
             'Спорт / Фитнесс',
             0,
             NOW(),
             0,
             NOW(),
             9
         );

INSERT INTO category (
    category_id,
    category_description,
    category_name,
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    media_id
) VALUES (
             8,
             'Массаж',
             'Массаж',
             0,
             NOW(),
             0,
             NOW(),
             10
         );

-- Metric

INSERT INTO metric (
    metric_id,
    created_by,
    created_datetime,
    max_value,
    metric_description,
    metric_name,
    min_value,
    modified_by,
    modified_datetime
) VALUES (
             1,
             0,
             NOW(),
             5,
             'Сэтгэл ханамжийн хамгийн ерөнхий үнэлгээ',
             'Сэтгэл ханамж',
             0,
             0,
             NOW()
         );


-- Category Metric Connection

INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             1,
             1
         );

INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             2,
             1
         );

INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             3,
             1
         );

INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             4,
             1
         );

INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             5,
             1
         );

INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             6,
             1
         );

INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             7,
             1
         );


INSERT INTO category_metric (
    created_by,
    created_datetime,
    modified_by,
    modified_datetime,
    category_id,
    metric_id
) VALUES (
             0,
             NOW(),
             0,
             NOW(),
             8,
             1
         );


-- Food- Dodo Pizza, Mongolians, Ogooj, Prada Chicken, Mexican Restaurant
-- Attraction - Gorkhi-Terelj National Park, Chinggis Khaan Statue Complex, Zaisan Memorial
-- Hotel - Kempinski Hotel Khan Palace, Shangri-La Hotel Ulaanbaatar, Best Western Premier Tuushin Hotel
-- Fun - Tennis Billiard, iLoft
-- Beauty - Milyy Beauty Lounge, G-Implant шүдний эмнэлэг
-- Karoake - Venice karaoke / Венец караоке
-- Sport - Gold's Gym, Zeus Gym Fight Center
-- Massage - Nana spa

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             11,
             '2025-12-07 21:19:58.984',
             '/uploads/business/2025-12-07/8006bcb2-7d14-4556-bd6b-7b166e7523b7_dodo.jpg',
             'dodo.jpg',
             'business'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             12,
             '2025-12-07 21:20:36.347',
             '/uploads/business/2025-12-07/06e7ccad-82e7-41fd-81bf-8ec8572e07f1_mongolians.jpg',
             'mongolians.jpg',
             'business'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             13,
             '2025-12-07 21:21:24.600',
             '/uploads/business/2025-12-07/bfc697f2-7bbe-4b4e-a8cf-228e85a5a552_ogooj.jpg',
             'ogooj.jpg',
             'business'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             14,
             '2025-12-07 21:23:11.087',
             '/uploads/business/2025-12-07/749fc933-7981-4db0-a141-16c7d5a465cd_prada-chicken.jpg',
             'prada-chicken.jpg',
             'business'
         );

INSERT INTO media (
    media_id,
    created_at,
    file_path,
    original_name,
    subject
) VALUES (
             15,
             '2025-12-07 21:26:58.303',
             '/uploads/business/2025-12-07/c97fcb62-a771-41d1-ae89-7cf7d22ed377_torres.jpg',
             'torres.jpg',
             'business'
         );

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(16, '2025-12-13 17:01:45.436', '/uploads/business/2025-12-13/5118ca9a-4c03-43fa-b949-fe84d85b2d68_gorkhi-terelj.jpg', 'gorkhi-terelj.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(17, '2025-12-13 17:02:02.684', '/uploads/business/2025-12-13/bc1d116e-91d6-42ef-a277-c3fa62f46067_tsonjin-boldog.jpg', 'tsonjin-boldog.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(18, '2025-12-13 17:02:15.110', '/uploads/business/2025-12-13/b81076fb-2a04-4919-a476-282da5c5f37d_zaisan-monument.jpg', 'zaisan-monument.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(19, '2025-12-13 17:02:30.267', '/uploads/business/2025-12-13/2d0e3a9e-e96a-4c14-aab7-7deba27b16f3_kempinski.jpg', 'kempinski.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(20, '2025-12-13 17:02:46.926', '/uploads/business/2025-12-13/c4762b58-9292-4a46-8eb1-bf8044431af3_shangrila-hotel.jpg', 'shangrila-hotel.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(21, '2025-12-13 17:02:56.178', '/uploads/business/2025-12-13/29f0e633-a1b4-49f4-8151-43015cda2dbc_tuushin.jpg', 'tuushin.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(22, '2025-12-13 17:03:08.297', '/uploads/business/2025-12-13/78f873dc-415c-46d7-bc67-f3c64ca2fa63_tennis-billiard-shine.jpg', 'tennis-billiard-shine.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(23, '2025-12-13 17:03:19.495', '/uploads/business/2025-12-13/6c066728-2ba9-4a80-8064-32c72414b452_iloft.jpg', 'iloft.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(24, '2025-12-13 17:03:28.340', '/uploads/business/2025-12-13/f6845b9f-0ab9-489a-a08d-9d94ac9a54fb_milyy-beauty-lounge.jpg', 'milyy-beauty-lounge.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(25, '2025-12-13 17:03:36.189', '/uploads/business/2025-12-13/a176a4f1-f319-4944-bd98-dc01c5ad7a94_g-implant.png', 'g-implant.png', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(26, '2025-12-13 17:03:48.001', '/uploads/business/2025-12-13/8e4a2a86-a6af-414e-8ef9-2ff79e87096d_venice-karaoke.jpg', 'venice-karaoke.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(27, '2025-12-13 17:03:56.197', '/uploads/business/2025-12-13/76afa31f-f79d-44a5-8bc4-a9f9ddee3e82_goldsgym.jpg', 'goldsgym.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(28, '2025-12-13 17:04:04.851', '/uploads/business/2025-12-13/e9d73a01-a0fb-470f-994f-cc34f3e301f5_zeus-gym.jpg', 'zeus-gym.jpg', 'business');

INSERT INTO media
(media_id, created_at, file_path, original_name, subject)
VALUES(29, '2025-12-13 17:04:12.935', '/uploads/business/2025-12-13/559c2365-b42d-4d5e-a64d-80939bf18a68_nana-spa.jpg', 'nana-spa.jpg', 'business');

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             1,
             '32/4, BZD - 43 khoroo, Ulaanbaatar 13372',
             'Dodo Pizza',
             0,
             NOW(),
             '',
             0,
             47.91276134627459,
             106.93708257043161,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             1,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             2,
             'Olympic Street, 4th floor, Shangri-La Mall, Ulaanbaatar 14241',
             'Mongolians Restaurant',
             0,
             NOW(),
             '',
             0,
             47.91363346964478,
             106.92151034232788,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );


INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             3,
             'WWCG+3H8, SBD - 8 khoroo, Ulaanbaatar 14191',
             'Өгөөж цайны газар',
             0,
             NOW(),
             '',
             0,
             47.92049865779869,
             106.92654931276097,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );


INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             4,
             'WW94+3J4 Баруун Сэлбийн гудамж, CHD - 3 khoroo, Ulaanbaatar 15172',
             'PRADA CHICKEN',
             0,
             NOW(),
             '',
             0,
             47.91851229576952,
             106.90679736806578,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             5,
             null,
             null
         );


INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             5,
             'Tokyo St Palazzo center, Suit 8, Ulaanbaatar 14200',
             'Torres restaurant',
             0,
             NOW(),
             '',
             0,
             47.925452095054894,
             106.93577801308837,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             1,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             6,
             'Энхтайвны Өргөн Чөлөө 206, Улаанбаатар',
             'Gorkhi Terelj National Park',
             0,
             NOW(),
             '',
             0,
             48.166157290694755,
          107.73593775516333,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             1,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             7,
             'Ulaanbaatar Chinggis Khaan Statue, ND - 5 khoroo, Nalaikh, Ulaanbaatar 12593',
             'Chinggis Khaan Statue Complex',
             0,
             NOW(),
             '',
             0,
             47.80827826709269,
          107.52975265331195,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             7,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             8,
             'VWM8+J5C, HUD - 11 khoroo, Ulaanbaatar 17023',
             'Zaisan Monument',
             0,
             NOW(),
             '',
             0,
             47.88416830755894, 106.91528996680698,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             4,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             9,
             'Peace Avenue 13345 East Cross Road, BZD - 7 khoroo, Ulaanbaatar 13345',
             'Kempinski Hotel Khan Palace Ulaanbaatar',
             0,
             NOW(),
             '',
             0,
             47.919904619549506, 106.94345692440098,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             1,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             10,
             'Olympic Street 19, District-1, Ulaanbaatar 14241',
             'Shangri-La Ulaanbaatar',
             0,
             NOW(),
             '',
             0,
             47.91311147512117, 106.92014352448032,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             11,
             'Prime Minister A.Amar St 15, SBD - 8 khoroo, Ulaanbaatar 14200',
             'Best Western Premier Tuushin Hotel',
             0,
             NOW(),
             '',
             0,
             47.921053439769096, 106.92053018029556,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             12,
             'WWFC+WG3 Бага тойруу, BZD - 6 khoroo, Ulaanbaatar 14200',
             'Shine Billiard & Club',
             0,
             NOW(),
             '',
             0,
             47.924880817645075, 106.92125493974667,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             1,
             null,
             null
         );


INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             13,
             'WWCC+648 Way to Migma Centre, SBD - 8 khoroo, Ulaanbaatar 14200',
             'Iloft club',
             0,
             NOW(),
             '',
             0,
             47.92067318186771, 106.92028205331667,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );


INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             14,
             'WW9F+MH3, SBD - 8 khoroo, Ulaanbaatar 14191',
             'Milyy Beauty Lounge',
             0,
             NOW(),
             '',
             0,
             47.91929887224416, 106.92393121276136,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             15,
             'Бага тойруу 64, SBD - 8 khoroo, Ulaanbaatar 97600',
             'G-Implant шүдний эмнэлэг',
             0,
             NOW(),
             '',
             0,
             47.91965113404699, 106.92312654995968,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             16,
             'Сүхбаатарын талбайн Хангарьд ордны баруун талд, Төв шуудангийн чанх хойно, Ulaanbaatar',
             'Venice karaoke / Венец караоке',
             0,
             NOW(),
             '',
             0,
             47.91828480742559, 106.91516072633291,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             17,
             'BZD - 36 khoroo, Ulaanbaatar 13311',
             'Golds Gym',
             0,
             NOW(),
             '',
             0,
             47.905269706906616, 106.94314856680788,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             1,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             18,
             'WW5M+M46, BZD - 43 khoroo, Ulaanbaatar 13374',
             'Zeus Gym Fight Center',
             0,
             NOW(),
             '',
             0,
             47.90928103707159, 106.93272571098831,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             1,
             null,
             null
         );

INSERT INTO business (
    business_id,
    address,
    business_name,
    created_by,
    created_datetime,
    email,
    floor_number,
    latitude,
    longitude,
    modified_by,
    modified_datetime,
    status,
    working_hours,
    district_id,
    place_id,
    user_id
) VALUES (
             19,
             'Olympic Street Nab group center 7th floor, SBD - 1 khoroo, Ulaanbaatar 14240',
             'Nana spa',
             0,
             NOW(),
             '',
             0,
             47.91537871429127, 106.92023156866071,
             0,
             NOW(),
             'UNVERIFIED',
             '08:00-22:00',
             6,
             null,
             null
         );

INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(1, 0, NOW(), 1, 11);

INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(2, 0, NOW(), 2, 12);

INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(3, 0, NOW(), 3, 13);

INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(4, 0, NOW(), 4, 14);

INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(5, 0, NOW(), 5, 15);

INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(6, 0, NOW(), 6, 16);

INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(7, 0, NOW(), 7, 17);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(8, 0, NOW(), 8, 18);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(9, 0, NOW(), 9, 19);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(10, 0, NOW(), 10, 20);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(11, 0, NOW(), 11, 21);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(12, 0, NOW(), 12, 22);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(13, 0, NOW(), 13, 23);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(14, 0, NOW(), 14, 24);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(15, 0, NOW(), 15, 25);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(16, 0, NOW(), 16, 26);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(17, 0, NOW(), 17, 27);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(18, 0, NOW(), 18, 28);
INSERT INTO business_media
(id, created_by, created_datetime, business_id, media_id)
VALUES(19, 0, NOW(), 19, 29);


INSERT INTO business_category
(id, business_id, category_id)
VALUES(1, 1, 1);
INSERT INTO business_category
(id, business_id, category_id)
VALUES(2, 2, 1);
INSERT INTO business_category
(id, business_id, category_id)
VALUES(3, 3, 1);
INSERT INTO business_category
(id, business_id, category_id)
VALUES(4, 4, 1);
INSERT INTO business_category
(id, business_id, category_id)
VALUES(5, 5, 1);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(6, 6, 2);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(7, 7, 2);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(8, 8, 2);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(9, 9, 3);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(10, 10, 3);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(11, 11, 3);


INSERT INTO business_category
(id, business_id, category_id)
VALUES(12, 12, 4);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(13, 13, 4);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(14, 14, 5);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(15, 15, 5);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(16, 16, 6);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(17, 17, 7);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(18, 18, 7);

INSERT INTO business_category
(id, business_id, category_id)
VALUES(19, 19, 8);

---- seq updates

SELECT setval(pg_get_serial_sequence('country', 'country_id'), (SELECT MAX(country_id) FROM country));
SELECT setval(pg_get_serial_sequence('province', 'province_id'), (SELECT MAX(province_id) FROM province));
SELECT setval(pg_get_serial_sequence('district', 'district_id'), (SELECT MAX(district_id) FROM district));
SELECT setval(pg_get_serial_sequence('place', 'place_id'), (SELECT MAX(place_id) FROM place));
SELECT setval(pg_get_serial_sequence('media', 'media_id'), (SELECT MAX(media_id) FROM media));
SELECT setval(pg_get_serial_sequence('users', 'user_id'), (SELECT MAX(user_id) FROM users));
SELECT setval(pg_get_serial_sequence('category', 'category_id'), (SELECT MAX(category_id) FROM category));
SELECT setval(pg_get_serial_sequence('metric', 'metric_id'), (SELECT MAX(metric_id) FROM metric));
SELECT setval(pg_get_serial_sequence('business', 'business_id'), (SELECT MAX(business_id) FROM business));
SELECT setval(pg_get_serial_sequence('business_media', 'id'), (SELECT MAX(id) FROM business_media));
SELECT setval(pg_get_serial_sequence('business_category', 'id'), (SELECT MAX(id) FROM business_category));

