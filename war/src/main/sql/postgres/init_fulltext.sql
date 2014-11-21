/*********************************************************************************************************************/
/* person */

ALTER TABLE person ADD COLUMN fulltext_names TSVECTOR;
UPDATE person
SET fulltext_names = (
  to_tsvector('english', coalesce(given, '') || ' ' || coalesce(family, '') || ' ' || coalesce("middleName", '')) ||
  to_tsvector('russian', coalesce(given, '') || ' ' || coalesce(family, '') || ' ' || coalesce("middleName", '')));

CREATE INDEX "fulltext_names_idx"
ON person
USING GIN (person.fulltext_names);

CREATE FUNCTION person_trigger()
  RETURNS TRIGGER AS $$
BEGIN
  new.fulltext_names :=
  to_tsvector('pg_catalog.english',
              coalesce(new.given, '') || ' ' || coalesce(new.family, '') || ' ' || coalesce(new."middleName", '')) ||
  to_tsvector('pg_catalog.russian',
              coalesce(new.given, '') || ' ' || coalesce(new.family, '') || ' ' || coalesce(new."middleName", ''));
  RETURN new;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER personupdate BEFORE INSERT OR UPDATE ON person FOR EACH ROW EXECUTE PROCEDURE person_trigger();

/*********************************************************************************************************************/
/* attr */

ALTER TABLE attr ADD COLUMN fulltext_attr TSVECTOR;
UPDATE attr
SET fulltext_attr = (to_tsvector('english', value) || to_tsvector('russian', value));

CREATE INDEX "fulltext_attr_idx" ON attr USING GIN (fulltext_attr);

CREATE FUNCTION attr_trigger()
  RETURNS TRIGGER AS $$
BEGIN
  new.fulltext_attr :=
  to_tsvector('pg_catalog.english', new.value) ||
  to_tsvector('pg_catalog.russian', new.value);
  RETURN new;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER attrupdate BEFORE INSERT OR UPDATE ON attr FOR EACH ROW EXECUTE PROCEDURE attr_trigger();

/*********************************************************************************************************************/
/* addr */

ALTER TABLE addr ADD COLUMN fulltext_addr TSVECTOR;
UPDATE addr
SET fulltext_addr = (
  to_tsvector('english', coalesce("additionalLocator", '') || ' ' ||
                         coalesce("buildingNumberSuffix", '') || ' ' ||
                         coalesce("careOf", '') || ' ' ||
                         coalesce("censusTract", '') || ' ' ||
                         coalesce("city", '') || ' ' ||
                         coalesce("country", '') || ' ' ||
                         coalesce("county", '') || ' ' ||
                         coalesce("delimiter", '') || ' ' ||
                         coalesce("deliveryAddressLine", '') || ' ' ||
                         coalesce("deliveryInstallationArea", '') || ' ' ||
                         coalesce("deliveryInstallationQualifier", '') || ' ' ||
                         coalesce("deliveryInstallationType", '') || ' ' ||
                         coalesce("deliveryMode", '') || ' ' ||
                         coalesce("deliveryModeIdentifier", '') || ' ' ||
                         coalesce("direction", '') || ' ' ||
                         coalesce("houseNumber", '') || ' ' ||
                         coalesce("houseNumberNumeric", '') || ' ' ||
                         coalesce("postBox", '') || ' ' ||
                         coalesce("postalCode", '') || ' ' ||
                         coalesce("precinct", '') || ' ' ||
                         coalesce("state", '') || ' ' ||
                         coalesce("streetAddressLine", '') || ' ' ||
                         coalesce("streetName", '') || ' ' ||
                         coalesce("streetNameBase", '') || ' ' ||
                         coalesce("streetNameType", '') || ' ' ||
                         coalesce("unitID", '') || ' ' ||
                         coalesce("unitType", '')) ||

  to_tsvector('russian', coalesce("additionalLocator", '') || ' ' ||
                         coalesce("buildingNumberSuffix", '') || ' ' ||
                         coalesce("careOf", '') || ' ' ||
                         coalesce("censusTract", '') || ' ' ||
                         coalesce("city", '') || ' ' ||
                         coalesce("country", '') || ' ' ||
                         coalesce("county", '') || ' ' ||
                         coalesce("delimiter", '') || ' ' ||
                         coalesce("deliveryAddressLine", '') || ' ' ||
                         coalesce("deliveryInstallationArea", '') || ' ' ||
                         coalesce("deliveryInstallationQualifier", '') || ' ' ||
                         coalesce("deliveryInstallationType", '') || ' ' ||
                         coalesce("deliveryMode", '') || ' ' ||
                         coalesce("deliveryModeIdentifier", '') || ' ' ||
                         coalesce("direction", '') || ' ' ||
                         coalesce("houseNumber", '') || ' ' ||
                         coalesce("houseNumberNumeric", '') || ' ' ||
                         coalesce("postBox", '') || ' ' ||
                         coalesce("postalCode", '') || ' ' ||
                         coalesce("precinct", '') || ' ' ||
                         coalesce("state", '') || ' ' ||
                         coalesce("streetAddressLine", '') || ' ' ||
                         coalesce("streetName", '') || ' ' ||
                         coalesce("streetNameBase", '') || ' ' ||
                         coalesce("streetNameType", '') || ' ' ||
                         coalesce("unitID", '') || ' ' ||
                         coalesce("unitType", '')));

CREATE INDEX "fulltext_addr_idx" ON addr USING GIN (fulltext_addr);

CREATE FUNCTION addr_trigger()
  RETURNS TRIGGER AS $$
BEGIN
  new.fulltext_addr :=
  to_tsvector('pg_catalog.english', coalesce(new."additionalLocator", '') || ' ' ||
                                    coalesce(new."buildingNumberSuffix", '') || ' ' ||
                                    coalesce(new."careOf", '') || ' ' ||
                                    coalesce(new."censusTract", '') || ' ' ||
                                    coalesce(new."city", '') || ' ' ||
                                    coalesce(new."country", '') || ' ' ||
                                    coalesce(new."county", '') || ' ' ||
                                    coalesce(new."delimiter", '') || ' ' ||
                                    coalesce(new."deliveryAddressLine", '') || ' ' ||
                                    coalesce(new."deliveryInstallationArea", '') || ' ' ||
                                    coalesce(new."deliveryInstallationQualifier", '') || ' ' ||
                                    coalesce(new."deliveryInstallationType", '') || ' ' ||
                                    coalesce(new."deliveryMode", '') || ' ' ||
                                    coalesce(new."deliveryModeIdentifier", '') || ' ' ||
                                    coalesce(new."direction", '') || ' ' ||
                                    coalesce(new."houseNumber", '') || ' ' ||
                                    coalesce(new."houseNumberNumeric", '') || ' ' ||
                                    coalesce(new."postBox", '') || ' ' ||
                                    coalesce(new."postalCode", '') || ' ' ||
                                    coalesce(new."precinct", '') || ' ' ||
                                    coalesce(new."state", '') || ' ' ||
                                    coalesce(new."streetAddressLine", '') || ' ' ||
                                    coalesce(new."streetName", '') || ' ' ||
                                    coalesce(new."streetNameBase", '') || ' ' ||
                                    coalesce(new."streetNameType", '') || ' ' ||
                                    coalesce(new."unitID", '') || ' ' ||
                                    coalesce(new."unitType") ||
  to_tsvector('pg_catalog.russian', coalesce(new."additionalLocator", '') || ' ' ||
                                    coalesce(new."buildingNumberSuffix", '') || ' ' ||
                                    coalesce(new."careOf", '') || ' ' ||
                                    coalesce(new."censusTract", '') || ' ' ||
                                    coalesce(new."city", '') || ' ' ||
                                    coalesce(new."country", '') || ' ' ||
                                    coalesce(new."county", '') || ' ' ||
                                    coalesce(new."delimiter", '') || ' ' ||
                                    coalesce(new."deliveryAddressLine", '') || ' ' ||
                                    coalesce(new."deliveryInstallationArea", '') || ' ' ||
                                    coalesce(new."deliveryInstallationQualifier", '') || ' ' ||
                                    coalesce(new."deliveryInstallationType", '') || ' ' ||
                                    coalesce(new."deliveryMode", '') || ' ' ||
                                    coalesce(new."deliveryModeIdentifier", '') || ' ' ||
                                    coalesce(new."direction", '') || ' ' ||
                                    coalesce(new."houseNumber", '') || ' ' ||
                                    coalesce(new."houseNumberNumeric", '') || ' ' ||
                                    coalesce(new."postBox", '') || ' ' ||
                                    coalesce(new."postalCode", '') || ' ' ||
                                    coalesce(new."precinct", '') || ' ' ||
                                    coalesce(new."state", '') || ' ' ||
                                    coalesce(new."streetAddressLine", '') || ' ' ||
                                    coalesce(new."streetName", '') || ' ' ||
                                    coalesce(new."streetNameBase", '') || ' ' ||
                                    coalesce(new."streetNameType", '') || ' ' ||
                                    coalesce(new."unitID", '') || ' ' ||
                                    coalesce(new."unitType", '')));
  RETURN new;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER addrupdate BEFORE INSERT OR UPDATE ON addr FOR EACH ROW EXECUTE PROCEDURE addr_trigger();

/*********************************************************************************************************************/
/* telecom */

ALTER TABLE telecom ADD COLUMN fulltext_telecom TSVECTOR;
UPDATE telecom
SET fulltext_telecom = (to_tsvector('english', value) || to_tsvector('russian', value));

CREATE INDEX "fulltext_telecom_idx" ON telecom USING GIN (fulltext_telecom);

CREATE FUNCTION telecom_trigger()
  RETURNS TRIGGER AS $$
BEGIN
  new.fulltext_telecom :=
  to_tsvector('pg_catalog.english', new.value) ||
  to_tsvector('pg_catalog.russian', new.value);
  RETURN new;
END
$$ LANGUAGE plpgsql;

CREATE TRIGGER telecomupdate BEFORE INSERT OR UPDATE ON telecom FOR EACH ROW EXECUTE PROCEDURE telecom_trigger();