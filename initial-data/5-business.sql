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