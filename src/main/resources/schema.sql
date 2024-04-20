create table if not exists athlete_country(
    athleteId int,
    countryId int,
    primary key(athleteId, countryId),
    foreign key(athleteId) references athlete(id),
    foreign key(countryId) references country(id)
);