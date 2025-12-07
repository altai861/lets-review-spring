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