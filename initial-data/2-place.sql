INSERT INTO place (
    place_id,
    place_name,
    description,
    address,
    latitude,
    longitude,
    floorNumber,
    created_datetime,
    created_by,
    modified_datetime,
    modified_by
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
)


INSERT INTO place (
    place_id,
    place_name,
    description,
    address,
    latitude,
    longitude,
    floorNumber,
    created_datetime,
    created_by,
    modified_datetime,
    modified_by
    district_id
) VALUES (
    2,
    'Улсын их дэлгүүр',
    'Монгол улсын анхны их дэлгүүр',
    'CHD - 3 khoroo, Ulaanbaatar 15172',
    47.91703280186287, 
    106.9063869938821
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
    media_media_id
    created_datetime
) VALUES (
    1,
    1,
    NOW()
);

INSERT INTO place_media (
    place_place_id,
    media_media_id
    created_datetime
) VALUES (
    2,
    2,
    NOW()
);



