create TABLE country(
   alpha2Code                      VARCHAR(2) NOT NULL PRIMARY KEY
  ,alpha3Code                      VARCHAR(3)
  ,area                            INTEGER
  ,capital                         VARCHAR(19)
  ,demonym                         VARCHAR(45)
  ,flag                            VARCHAR(37)
  ,gini                            NUMERIC(4,1)
  ,name                            VARCHAR(52)
  ,native_name                      VARCHAR(70)
  ,numeric_code                    VARCHAR(10)
  ,population                      INTEGER
  ,region                          VARCHAR(8)
  ,subregion                       VARCHAR(25)
  ,cioc                            VARCHAR(3)
);
create TABLE translations(
  alpha2Code                      VARCHAR(2) NOT NULL PRIMARY KEY
  ,br                             VARCHAR(100)
  ,de                             VARCHAR(100)
  ,es                             VARCHAR(100)
  ,fa                             VARCHAR(100)
  ,fr                             VARCHAR(100)
  ,hr                             VARCHAR(100)
  ,it                             VARCHAR(100)
  ,ja                             VARCHAR(100)
  ,nl                             VARCHAR(100)
  ,pt                             VARCHAR(100)
);
create TABLE currencies(
  code                           VARCHAR(6) NOT NULL PRIMARY KEY
  ,name                           VARCHAR(50)
  ,symbol                         VARCHAR(10)
);
create TABLE country_currencies(
  country_alpha2Code              VARCHAR(2) NOT NULL
  ,currencies_code                VARCHAR(6) NOT NULL
);
create TABLE country_borders(
  country_alpha2code             VARCHAR(2) NOT NULL
  ,borders                       VARCHAR(3) NOT NULL
);
create TABLE country_alt_spellings(
  country_alpha2code             VARCHAR(2) NOT NULL
 ,alt_spellings                  VARCHAR(200) NOT NULL
);
create TABLE country_calling_codes(
  country_alpha2code             VARCHAR(2) NOT NULL
 ,calling_codes                  VARCHAR(6) NOT NULL
);
create TABLE country_top_level_domain(
  country_alpha2code             VARCHAR(2) NOT NULL
 ,top_level_domain               VARCHAR(10) NOT NULL
);
create TABLE country_latlng(
  country_alpha2code             VARCHAR(2) NOT NULL
 ,latlng                         NUMERIC(14,8) NOT NULL
);
create TABLE country_timezones(
  country_alpha2code             VARCHAR(2) NOT NULL
 ,timezone                       VARCHAR(9) NOT NULL
);
create TABLE languages(
   iso639_1                       VARCHAR(2)
  ,iso639_2                       VARCHAR(3) NOT NULL PRIMARY KEY
  ,name                           VARCHAR(50) NOT NULL
  ,native_name                     VARCHAR(50) NOT NULL
);
create TABLE country_languages(
  country_alpha2Code              VARCHAR(2) NOT NULL
  ,languages_iso639_2             VARCHAR(3) NOT NULL
);

create TABLE regional_blocs(
  acronym                        VARCHAR(50) NOT NULL PRIMARY KEY
  ,name                           VARCHAR(50)
);
create TABLE country_regional_blocs(
  country_alpha2Code             VARCHAR(2) NOT NULL
  ,regional_blocs_acronym        VARCHAR(50) NOT NULL
);
create TABLE regional_blocs_other_acronyms(
  regional_blocs_acronym         VARCHAR(50) NOT NULL
 ,other_acronyms                 VARCHAR(50) NOT NULL
);
create TABLE regional_blocs_other_names(
  regional_blocs_acronym        VARCHAR(50) NOT NULL
 ,other_names                   VARCHAR(50) NOT NULL
);