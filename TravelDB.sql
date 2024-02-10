PGDMP  &    *        
        |            TravelDB    15.6    16.2 3    :           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ;           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            <           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            =           1262    16740    TravelDB    DATABASE     �   CREATE DATABASE "TravelDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "TravelDB";
                postgres    false            �            1259    16742    hotels    TABLE     �  CREATE TABLE public.hotels (
    hotel_id integer NOT NULL,
    hotel_name character varying(255) NOT NULL,
    hotel_address character varying(255) NOT NULL,
    hotel_city character varying(100) NOT NULL,
    hotel_email character varying(100),
    hotel_phone character varying(50),
    hotel_star_rating integer,
    free_parking boolean NOT NULL,
    free_wifi boolean NOT NULL,
    hotel_concierge boolean NOT NULL,
    room_service_24_7 boolean NOT NULL,
    fitness_center boolean NOT NULL,
    spa boolean NOT NULL,
    swimming_pool boolean NOT NULL,
    CONSTRAINT hotels_hotel_star_rating_check CHECK (((hotel_star_rating >= 1) AND (hotel_star_rating <= 5)))
);
    DROP TABLE public.hotels;
       public         heap    postgres    false            �            1259    16741    hotels_hotel_id_seq    SEQUENCE     �   CREATE SEQUENCE public.hotels_hotel_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.hotels_hotel_id_seq;
       public          postgres    false    215            >           0    0    hotels_hotel_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.hotels_hotel_id_seq OWNED BY public.hotels.hotel_id;
          public          postgres    false    214            �            1259    16769    pension_types    TABLE     �   CREATE TABLE public.pension_types (
    pension_id integer NOT NULL,
    hotel_id integer NOT NULL,
    type character varying(255) NOT NULL
);
 !   DROP TABLE public.pension_types;
       public         heap    postgres    false            �            1259    16768    pension_types_pension_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pension_types_pension_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 3   DROP SEQUENCE public.pension_types_pension_id_seq;
       public          postgres    false    219            ?           0    0    pension_types_pension_id_seq    SEQUENCE OWNED BY     ]   ALTER SEQUENCE public.pension_types_pension_id_seq OWNED BY public.pension_types.pension_id;
          public          postgres    false    218            �            1259    16793    reservations    TABLE     R  CREATE TABLE public.reservations (
    reservation_id integer NOT NULL,
    room_id integer NOT NULL,
    check_in_date date NOT NULL,
    check_out_date date NOT NULL,
    total_price double precision NOT NULL,
    guest_count integer NOT NULL,
    guest_name character varying(255) NOT NULL,
    guest_citizen_id character varying(50) NOT NULL,
    guest_mail character varying(100),
    guest_phone character varying(50),
    CONSTRAINT reservations_guest_count_check CHECK ((guest_count > 0)),
    CONSTRAINT reservations_total_price_check CHECK ((total_price >= (0)::double precision))
);
     DROP TABLE public.reservations;
       public         heap    postgres    false            �            1259    16792    reservations_reservation_id_seq    SEQUENCE     �   CREATE SEQUENCE public.reservations_reservation_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.reservations_reservation_id_seq;
       public          postgres    false    223            @           0    0    reservations_reservation_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.reservations_reservation_id_seq OWNED BY public.reservations.reservation_id;
          public          postgres    false    222            �            1259    16752    rooms    TABLE     G  CREATE TABLE public.rooms (
    room_id integer NOT NULL,
    hotel_id integer NOT NULL,
    type character varying(50) NOT NULL,
    stock integer NOT NULL,
    adult_price double precision NOT NULL,
    child_price double precision NOT NULL,
    bed_capacity integer NOT NULL,
    square_meter integer NOT NULL,
    television boolean NOT NULL,
    minibar boolean NOT NULL,
    game_console boolean NOT NULL,
    safe boolean NOT NULL,
    projection boolean NOT NULL,
    CONSTRAINT rooms_adult_price_check CHECK ((adult_price >= (0)::double precision)),
    CONSTRAINT rooms_bed_capacity_check CHECK ((bed_capacity > 0)),
    CONSTRAINT rooms_child_price_check CHECK ((child_price >= (0)::double precision)),
    CONSTRAINT rooms_square_meter_check CHECK ((square_meter > 0)),
    CONSTRAINT rooms_stock_check CHECK ((stock >= 0))
);
    DROP TABLE public.rooms;
       public         heap    postgres    false            �            1259    16751    rooms_room_id_seq    SEQUENCE     �   CREATE SEQUENCE public.rooms_room_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.rooms_room_id_seq;
       public          postgres    false    217            A           0    0    rooms_room_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.rooms_room_id_seq OWNED BY public.rooms.room_id;
          public          postgres    false    216            �            1259    16781    seasons    TABLE     �   CREATE TABLE public.seasons (
    season_id integer NOT NULL,
    hotel_id integer NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL
);
    DROP TABLE public.seasons;
       public         heap    postgres    false            �            1259    16780    seasons_season_id_seq    SEQUENCE     �   CREATE SEQUENCE public.seasons_season_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.seasons_season_id_seq;
       public          postgres    false    221            B           0    0    seasons_season_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.seasons_season_id_seq OWNED BY public.seasons.season_id;
          public          postgres    false    220            �            1259    16807    users    TABLE     �   CREATE TABLE public.users (
    user_id integer NOT NULL,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role text NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false            �            1259    16806    users_user_id_seq    SEQUENCE     �   CREATE SEQUENCE public.users_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.users_user_id_seq;
       public          postgres    false    225            C           0    0    users_user_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.users_user_id_seq OWNED BY public.users.user_id;
          public          postgres    false    224            ~           2604    16745    hotels hotel_id    DEFAULT     r   ALTER TABLE ONLY public.hotels ALTER COLUMN hotel_id SET DEFAULT nextval('public.hotels_hotel_id_seq'::regclass);
 >   ALTER TABLE public.hotels ALTER COLUMN hotel_id DROP DEFAULT;
       public          postgres    false    215    214    215            �           2604    16772    pension_types pension_id    DEFAULT     �   ALTER TABLE ONLY public.pension_types ALTER COLUMN pension_id SET DEFAULT nextval('public.pension_types_pension_id_seq'::regclass);
 G   ALTER TABLE public.pension_types ALTER COLUMN pension_id DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    16796    reservations reservation_id    DEFAULT     �   ALTER TABLE ONLY public.reservations ALTER COLUMN reservation_id SET DEFAULT nextval('public.reservations_reservation_id_seq'::regclass);
 J   ALTER TABLE public.reservations ALTER COLUMN reservation_id DROP DEFAULT;
       public          postgres    false    223    222    223                       2604    16755    rooms room_id    DEFAULT     n   ALTER TABLE ONLY public.rooms ALTER COLUMN room_id SET DEFAULT nextval('public.rooms_room_id_seq'::regclass);
 <   ALTER TABLE public.rooms ALTER COLUMN room_id DROP DEFAULT;
       public          postgres    false    217    216    217            �           2604    16784    seasons season_id    DEFAULT     v   ALTER TABLE ONLY public.seasons ALTER COLUMN season_id SET DEFAULT nextval('public.seasons_season_id_seq'::regclass);
 @   ALTER TABLE public.seasons ALTER COLUMN season_id DROP DEFAULT;
       public          postgres    false    220    221    221            �           2604    16810    users user_id    DEFAULT     n   ALTER TABLE ONLY public.users ALTER COLUMN user_id SET DEFAULT nextval('public.users_user_id_seq'::regclass);
 <   ALTER TABLE public.users ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    225    224    225            -          0    16742    hotels 
   TABLE DATA           �   COPY public.hotels (hotel_id, hotel_name, hotel_address, hotel_city, hotel_email, hotel_phone, hotel_star_rating, free_parking, free_wifi, hotel_concierge, room_service_24_7, fitness_center, spa, swimming_pool) FROM stdin;
    public          postgres    false    215   �A       1          0    16769    pension_types 
   TABLE DATA           C   COPY public.pension_types (pension_id, hotel_id, type) FROM stdin;
    public          postgres    false    219   �A       5          0    16793    reservations 
   TABLE DATA           �   COPY public.reservations (reservation_id, room_id, check_in_date, check_out_date, total_price, guest_count, guest_name, guest_citizen_id, guest_mail, guest_phone) FROM stdin;
    public          postgres    false    223   �A       /          0    16752    rooms 
   TABLE DATA           �   COPY public.rooms (room_id, hotel_id, type, stock, adult_price, child_price, bed_capacity, square_meter, television, minibar, game_console, safe, projection) FROM stdin;
    public          postgres    false    217   �A       3          0    16781    seasons 
   TABLE DATA           L   COPY public.seasons (season_id, hotel_id, start_date, end_date) FROM stdin;
    public          postgres    false    221   B       7          0    16807    users 
   TABLE DATA           B   COPY public.users (user_id, username, password, role) FROM stdin;
    public          postgres    false    225   "B       D           0    0    hotels_hotel_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.hotels_hotel_id_seq', 1, false);
          public          postgres    false    214            E           0    0    pension_types_pension_id_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.pension_types_pension_id_seq', 1, false);
          public          postgres    false    218            F           0    0    reservations_reservation_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.reservations_reservation_id_seq', 1, false);
          public          postgres    false    222            G           0    0    rooms_room_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.rooms_room_id_seq', 1, false);
          public          postgres    false    216            H           0    0    seasons_season_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.seasons_season_id_seq', 1, false);
          public          postgres    false    220            I           0    0    users_user_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.users_user_id_seq', 1, false);
          public          postgres    false    224            �           2606    16750    hotels hotels_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.hotels
    ADD CONSTRAINT hotels_pkey PRIMARY KEY (hotel_id);
 <   ALTER TABLE ONLY public.hotels DROP CONSTRAINT hotels_pkey;
       public            postgres    false    215            �           2606    16774     pension_types pension_types_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.pension_types
    ADD CONSTRAINT pension_types_pkey PRIMARY KEY (pension_id);
 J   ALTER TABLE ONLY public.pension_types DROP CONSTRAINT pension_types_pkey;
       public            postgres    false    219            �           2606    16800    reservations reservations_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT reservations_pkey PRIMARY KEY (reservation_id);
 H   ALTER TABLE ONLY public.reservations DROP CONSTRAINT reservations_pkey;
       public            postgres    false    223            �           2606    16762    rooms rooms_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT rooms_pkey PRIMARY KEY (room_id);
 :   ALTER TABLE ONLY public.rooms DROP CONSTRAINT rooms_pkey;
       public            postgres    false    217            �           2606    16786    seasons seasons_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.seasons
    ADD CONSTRAINT seasons_pkey PRIMARY KEY (season_id);
 >   ALTER TABLE ONLY public.seasons DROP CONSTRAINT seasons_pkey;
       public            postgres    false    221            �           2606    16814    users users_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    225            �           2606    16816    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public            postgres    false    225            �           2606    16775 )   pension_types pension_types_hotel_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pension_types
    ADD CONSTRAINT pension_types_hotel_id_fkey FOREIGN KEY (hotel_id) REFERENCES public.hotels(hotel_id) ON DELETE CASCADE;
 S   ALTER TABLE ONLY public.pension_types DROP CONSTRAINT pension_types_hotel_id_fkey;
       public          postgres    false    3213    215    219            �           2606    16801 &   reservations reservations_room_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reservations
    ADD CONSTRAINT reservations_room_id_fkey FOREIGN KEY (room_id) REFERENCES public.rooms(room_id) ON DELETE CASCADE;
 P   ALTER TABLE ONLY public.reservations DROP CONSTRAINT reservations_room_id_fkey;
       public          postgres    false    217    223    3215            �           2606    16763    rooms rooms_hotel_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.rooms
    ADD CONSTRAINT rooms_hotel_id_fkey FOREIGN KEY (hotel_id) REFERENCES public.hotels(hotel_id) ON DELETE CASCADE;
 C   ALTER TABLE ONLY public.rooms DROP CONSTRAINT rooms_hotel_id_fkey;
       public          postgres    false    215    3213    217            �           2606    16787    seasons seasons_hotel_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.seasons
    ADD CONSTRAINT seasons_hotel_id_fkey FOREIGN KEY (hotel_id) REFERENCES public.hotels(hotel_id) ON DELETE CASCADE;
 G   ALTER TABLE ONLY public.seasons DROP CONSTRAINT seasons_hotel_id_fkey;
       public          postgres    false    221    215    3213            -      x������ � �      1      x������ � �      5      x������ � �      /      x������ � �      3      x������ � �      7      x������ � �     