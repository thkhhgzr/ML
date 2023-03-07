SELECT DATE_PART('month', date) AS month, DATE_PART('year', date) AS year, brigade,
	COUNT(*) AS events_amount,
	SUM(deads) AS deads,
	CASE
		WHEN DATE_PART('month', date) IN (12, 1, 2, 3) THEN 'winter'
		WHEN DATE_PART('month', date) IN (5, 6, 7, 8) THEN 'summer'
		ELSE 'transition season'
	END season
FROM facha.events all_events
GROUP BY DATE_PART('month', date), DATE_PART('year', date), brigade
ORDER by DATE_PART('year', date), DATE_PART('month', date), brigade