package com.example.home.fakeData

import com.example.home.data.remote.dto.NYTimesMostPopularResponse
import com.example.home.serializeArticleData
import com.example.sharedData.model.Article
import com.example.utils.core.jsonParse

object MostPopularValid {

    val data = "{\n" +
            "    \"status\": \"OK\",\n" +
            "    \"copyright\": \"Copyright (c) 2024 The New York Times Company.  All Rights Reserved.\",\n" +
            "    \"num_results\": 5,\n" +
            "    \"results\": [\n" +
            "        {\n" +
            "            \"uri\": \"nyt://article/cfd27572-6ce4-5a28-9068-b6c71a03c1f2\",\n" +
            "            \"url\": \"https://www.nytimes.com/2024/05/12/opinion/mothers-day-daughters-cancer.html\",\n" +
            "            \"id\": 100000009457288,\n" +
            "            \"asset_id\": 100000009457288,\n" +
            "            \"source\": \"New York Times\",\n" +
            "            \"published_date\": \"2024-05-12\",\n" +
            "            \"updated\": \"2024-05-13 09:06:32\",\n" +
            "            \"section\": \"Opinion\",\n" +
            "            \"subsection\": \"\",\n" +
            "            \"nytdsection\": \"opinion\",\n" +
            "            \"adx_keywords\": \"Parenting;Mother's Day;Pregnancy and Childbirth;Love (Emotion);Birth Defects;Families and Family Life\",\n" +
            "            \"column\": null,\n" +
            "            \"byline\": \"By David French\",\n" +
            "            \"type\": \"Article\",\n" +
            "            \"title\": \"‘Dad, I Don’t Think I’m Old Enough to Handle This’\",\n" +
            "            \"abstract\": \"Our daughter was becoming a mother in the most difficult of circumstances.\",\n" +
            "            \"des_facet\": [\n" +
            "                \"Parenting\",\n" +
            "                \"Mother's Day\",\n" +
            "                \"Pregnancy and Childbirth\",\n" +
            "                \"Love (Emotion)\",\n" +
            "                \"Birth Defects\",\n" +
            "                \"Families and Family Life\"\n" +
            "            ],\n" +
            "            \"org_facet\": [],\n" +
            "            \"per_facet\": [],\n" +
            "            \"geo_facet\": [],\n" +
            "            \"media\": [\n" +
            "                {\n" +
            "                    \"type\": \"image\",\n" +
            "                    \"subtype\": \"photo\",\n" +
            "                    \"caption\": \"\",\n" +
            "                    \"copyright\": \"Sophie Ebrard\",\n" +
            "                    \"approved_for_syndication\": 0,\n" +
            "                    \"media-metadata\": [\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/14/opinion/12French1/12French1-thumbStandard.jpg\",\n" +
            "                            \"format\": \"Standard Thumbnail\",\n" +
            "                            \"height\": 75,\n" +
            "                            \"width\": 75\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/14/opinion/12French1/12French1-mediumThreeByTwo210.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo210\",\n" +
            "                            \"height\": 140,\n" +
            "                            \"width\": 210\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/14/opinion/12French1/12French1-mediumThreeByTwo440.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo440\",\n" +
            "                            \"height\": 293,\n" +
            "                            \"width\": 440\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"eta_id\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"uri\": \"nyt://article/73f6dccc-9dcc-5518-9aa0-91b166f63d4c\",\n" +
            "            \"url\": \"https://www.nytimes.com/2024/05/15/nyregion/social-media-scam-sextortion.html\",\n" +
            "            \"id\": 100000009319787,\n" +
            "            \"asset_id\": 100000009319787,\n" +
            "            \"source\": \"New York Times\",\n" +
            "            \"published_date\": \"2024-05-15\",\n" +
            "            \"updated\": \"2024-05-16 08:53:59\",\n" +
            "            \"section\": \"New York\",\n" +
            "            \"subsection\": \"\",\n" +
            "            \"nytdsection\": \"new york\",\n" +
            "            \"adx_keywords\": \"Computers and the Internet;Social Media;Sexting;Extortion and Blackmail;Frauds and Swindling;Instant Messaging;Suicides and Suicide Attempts;Suits and Litigation (Civil);Facebook Inc;Instagram Inc;Federal Bureau of Investigation;Homeland Security Department;Meta Platforms Inc\",\n" +
            "            \"column\": null,\n" +
            "            \"byline\": \"By Sarah Maslin Nir\",\n" +
            "            \"type\": \"Article\",\n" +
            "            \"title\": \"‘Chelsea’ Asked for Nude Pictures. Then the Sextortion Began.\",\n" +
            "            \"abstract\": \"Young men are being tricked into sending naked pictures to scammers pretending to be women — who then demand money. The consequences can be devastating.\",\n" +
            "            \"des_facet\": [\n" +
            "                \"Computers and the Internet\",\n" +
            "                \"Social Media\",\n" +
            "                \"Sexting\",\n" +
            "                \"Extortion and Blackmail\",\n" +
            "                \"Frauds and Swindling\",\n" +
            "                \"Instant Messaging\",\n" +
            "                \"Suicides and Suicide Attempts\",\n" +
            "                \"Suits and Litigation (Civil)\"\n" +
            "            ],\n" +
            "            \"org_facet\": [\n" +
            "                \"Facebook Inc\",\n" +
            "                \"Instagram Inc\",\n" +
            "                \"Federal Bureau of Investigation\",\n" +
            "                \"Homeland Security Department\",\n" +
            "                \"Meta Platforms Inc\"\n" +
            "            ],\n" +
            "            \"per_facet\": [],\n" +
            "            \"geo_facet\": [],\n" +
            "            \"media\": [\n" +
            "                {\n" +
            "                    \"type\": \"image\",\n" +
            "                    \"subtype\": \"photo\",\n" +
            "                    \"caption\": \"“David,” a 32-year-old pharmacy technician, fell for a sextortion scam. \",\n" +
            "                    \"copyright\": \"Jeenah Moon for The New York Times\",\n" +
            "                    \"approved_for_syndication\": 1,\n" +
            "                    \"media-metadata\": [\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/04/24/nyregion/00sextortion/00sextortion-thumbStandard.jpg\",\n" +
            "                            \"format\": \"Standard Thumbnail\",\n" +
            "                            \"height\": 75,\n" +
            "                            \"width\": 75\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/04/24/nyregion/00sextortion/00sextortion-mediumThreeByTwo210.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo210\",\n" +
            "                            \"height\": 140,\n" +
            "                            \"width\": 210\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/04/24/nyregion/00sextortion/00sextortion-mediumThreeByTwo440.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo440\",\n" +
            "                            \"height\": 293,\n" +
            "                            \"width\": 440\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"eta_id\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"uri\": \"nyt://interactive/5e2ea80d-e65c-5241-b988-bbb11c9f6604\",\n" +
            "            \"url\": \"https://www.nytimes.com/interactive/2024/05/15/opinion/trump-women-focus-group.html\",\n" +
            "            \"id\": 100000009468099,\n" +
            "            \"asset_id\": 100000009468099,\n" +
            "            \"source\": \"New York Times\",\n" +
            "            \"published_date\": \"2024-05-15\",\n" +
            "            \"updated\": \"2024-05-15 09:45:01\",\n" +
            "            \"section\": \"Opinion\",\n" +
            "            \"subsection\": \"\",\n" +
            "            \"nytdsection\": \"opinion\",\n" +
            "            \"adx_keywords\": \"Polls and Public Opinion;Voting and Voters;Women and Girls;Presidential Election of 2020;Presidential Election of 2024;Trump, Donald J\",\n" +
            "            \"column\": null,\n" +
            "            \"byline\": \"By Patrick Healy and Kristen Soltis Anderson\",\n" +
            "            \"type\": \"Interactive\",\n" +
            "            \"title\": \"These 12 Women Voted for Trump in 2020. How Do They See Him Now?\",\n" +
            "            \"abstract\": \"In our latest focus group, these voters said Trump was fallible in any number of ways, but that’s not what they cared about most.\",\n" +
            "            \"des_facet\": [\n" +
            "                \"Polls and Public Opinion\",\n" +
            "                \"Voting and Voters\",\n" +
            "                \"Women and Girls\",\n" +
            "                \"Presidential Election of 2020\",\n" +
            "                \"Presidential Election of 2024\"\n" +
            "            ],\n" +
            "            \"org_facet\": [],\n" +
            "            \"per_facet\": [\n" +
            "                \"Trump, Donald J\"\n" +
            "            ],\n" +
            "            \"geo_facet\": [],\n" +
            "            \"media\": [\n" +
            "                {\n" +
            "                    \"type\": \"image\",\n" +
            "                    \"subtype\": \"\",\n" +
            "                    \"caption\": \"\",\n" +
            "                    \"copyright\": \"\",\n" +
            "                    \"approved_for_syndication\": 0,\n" +
            "                    \"media-metadata\": [\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/15/opinion/trump-women-focus-group-1715708795597/trump-women-focus-group-1715708795597-thumbStandard.png\",\n" +
            "                            \"format\": \"Standard Thumbnail\",\n" +
            "                            \"height\": 75,\n" +
            "                            \"width\": 75\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/15/opinion/trump-women-focus-group-1715708795597/trump-women-focus-group-1715708795597-mediumThreeByTwo210.png\",\n" +
            "                            \"format\": \"mediumThreeByTwo210\",\n" +
            "                            \"height\": 140,\n" +
            "                            \"width\": 210\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/15/opinion/trump-women-focus-group-1715708795597/trump-women-focus-group-1715708795597-mediumThreeByTwo440.png\",\n" +
            "                            \"format\": \"mediumThreeByTwo440\",\n" +
            "                            \"height\": 293,\n" +
            "                            \"width\": 440\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"eta_id\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"uri\": \"nyt://article/034a6ed7-6000-55c0-b10d-bb8c1bfb5ea2\",\n" +
            "            \"url\": \"https://www.nytimes.com/2024/05/13/us/politics/biden-trump-battleground-poll.html\",\n" +
            "            \"id\": 100000009459687,\n" +
            "            \"asset_id\": 100000009459687,\n" +
            "            \"source\": \"New York Times\",\n" +
            "            \"published_date\": \"2024-05-13\",\n" +
            "            \"updated\": \"2024-05-14 08:29:54\",\n" +
            "            \"section\": \"U.S.\",\n" +
            "            \"subsection\": \"Politics\",\n" +
            "            \"nytdsection\": \"u.s.\",\n" +
            "            \"adx_keywords\": \"internal-open-access;Presidential Election of 2024;Polls and Public Opinion;United States Politics and Government;United States Economy;Hispanic-Americans;Black People;Abortion;Biden, Joseph R Jr;Trump, Donald J;Kennedy, Robert F Jr;New York Times/Siena College Poll;Philadelphia Inquirer;Republican Party;Democratic Party;Michigan;Pennsylvania;Wisconsin;Arizona;Georgia;Nevada\",\n" +
            "            \"column\": null,\n" +
            "            \"byline\": \"By Nate Cohn\",\n" +
            "            \"type\": \"Article\",\n" +
            "            \"title\": \"Trump Leads in 5 Key States, as Young and Nonwhite Voters Express Discontent With Biden\",\n" +
            "            \"abstract\": \"A new set of Times/Siena polls, including one with The Philadelphia Inquirer, reveal an erosion of support for the president among young and nonwhite voters upset about the economy and Gaza.\",\n" +
            "            \"des_facet\": [\n" +
            "                \"internal-open-access\",\n" +
            "                \"Presidential Election of 2024\",\n" +
            "                \"Polls and Public Opinion\",\n" +
            "                \"United States Politics and Government\",\n" +
            "                \"United States Economy\",\n" +
            "                \"Hispanic-Americans\",\n" +
            "                \"Black People\",\n" +
            "                \"Abortion\"\n" +
            "            ],\n" +
            "            \"org_facet\": [\n" +
            "                \"New York Times/Siena College Poll\",\n" +
            "                \"Philadelphia Inquirer\",\n" +
            "                \"Republican Party\",\n" +
            "                \"Democratic Party\"\n" +
            "            ],\n" +
            "            \"per_facet\": [\n" +
            "                \"Biden, Joseph R Jr\",\n" +
            "                \"Trump, Donald J\",\n" +
            "                \"Kennedy, Robert F Jr\"\n" +
            "            ],\n" +
            "            \"geo_facet\": [\n" +
            "                \"Michigan\",\n" +
            "                \"Pennsylvania\",\n" +
            "                \"Wisconsin\",\n" +
            "                \"Arizona\",\n" +
            "                \"Georgia\",\n" +
            "                \"Nevada\"\n" +
            "            ],\n" +
            "            \"media\": [\n" +
            "                {\n" +
            "                    \"type\": \"image\",\n" +
            "                    \"subtype\": \"photo\",\n" +
            "                    \"caption\": \"President Biden trails former President Donald J. Trump in polls of battleground states conducted by The New York Times, Siena College and The Philadelphia Inquirer.\",\n" +
            "                    \"copyright\": \"Haiyun Jiang for The New York Times\",\n" +
            "                    \"approved_for_syndication\": 1,\n" +
            "                    \"media-metadata\": [\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/13/multimedia/13pol-poll-battlegrounds-topart-zjtf/13pol-poll-battlegrounds-topart-zjtf-thumbStandard.jpg\",\n" +
            "                            \"format\": \"Standard Thumbnail\",\n" +
            "                            \"height\": 75,\n" +
            "                            \"width\": 75\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/13/multimedia/13pol-poll-battlegrounds-topart-zjtf/13pol-poll-battlegrounds-topart-zjtf-mediumThreeByTwo210.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo210\",\n" +
            "                            \"height\": 140,\n" +
            "                            \"width\": 210\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/13/multimedia/13pol-poll-battlegrounds-topart-zjtf/13pol-poll-battlegrounds-topart-zjtf-mediumThreeByTwo440.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo440\",\n" +
            "                            \"height\": 293,\n" +
            "                            \"width\": 440\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"eta_id\": 0\n" +
            "        },\n" +
            "        {\n" +
            "            \"uri\": \"nyt://article/b617ee8a-f849-5891-b9d8-663f661c1f2e\",\n" +
            "            \"url\": \"https://www.nytimes.com/2024/05/11/opinion/trump-stormy-daniels-trial.html\",\n" +
            "            \"id\": 100000009458621,\n" +
            "            \"asset_id\": 100000009458621,\n" +
            "            \"source\": \"New York Times\",\n" +
            "            \"published_date\": \"2024-05-11\",\n" +
            "            \"updated\": \"2024-05-13 13:04:56\",\n" +
            "            \"section\": \"Opinion\",\n" +
            "            \"subsection\": \"\",\n" +
            "            \"nytdsection\": \"opinion\",\n" +
            "            \"adx_keywords\": \"Presidential Election of 2024;New York State Criminal Case Against Trump (71543-23);Clifford, Stephanie (1979- );Necheles, Susan R;Trump, Donald J\",\n" +
            "            \"column\": null,\n" +
            "            \"byline\": \"By Maureen Dowd\",\n" +
            "            \"type\": \"Article\",\n" +
            "            \"title\": \"Donnie After Dark\",\n" +
            "            \"abstract\": \"A trial that is a meditation on Trump’s amorality.\",\n" +
            "            \"des_facet\": [\n" +
            "                \"Presidential Election of 2024\",\n" +
            "                \"New York State Criminal Case Against Trump (71543-23)\"\n" +
            "            ],\n" +
            "            \"org_facet\": [],\n" +
            "            \"per_facet\": [\n" +
            "                \"Clifford, Stephanie (1979- )\",\n" +
            "                \"Necheles, Susan R\",\n" +
            "                \"Trump, Donald J\"\n" +
            "            ],\n" +
            "            \"geo_facet\": [],\n" +
            "            \"media\": [\n" +
            "                {\n" +
            "                    \"type\": \"image\",\n" +
            "                    \"subtype\": \"photo\",\n" +
            "                    \"caption\": \"\",\n" +
            "                    \"copyright\": \"Johnny Louis/Getty Images\",\n" +
            "                    \"approved_for_syndication\": 1,\n" +
            "                    \"media-metadata\": [\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/14/opinion/11dowd/11dowd-thumbStandard.jpg\",\n" +
            "                            \"format\": \"Standard Thumbnail\",\n" +
            "                            \"height\": 75,\n" +
            "                            \"width\": 75\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/14/opinion/11dowd/11dowd-mediumThreeByTwo210.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo210\",\n" +
            "                            \"height\": 140,\n" +
            "                            \"width\": 210\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"url\": \"https://static01.nyt.com/images/2024/05/14/opinion/11dowd/11dowd-mediumThreeByTwo440.jpg\",\n" +
            "                            \"format\": \"mediumThreeByTwo440\",\n" +
            "                            \"height\": 293,\n" +
            "                            \"width\": 440\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"eta_id\": 0\n" +
            "        }\n" +
            "    ]\n" +
            "}"


    val emptyArticleResult = "{\n" +
            "    \"status\": \"OK\",\n" +
            "    \"copyright\": \"Copyright (c) 2024 The New York Times Company.  All Rights Reserved.\",\n" +
            "    \"num_results\": 0,\n" +
            "    \"results\": []\n" +
            "}"




    val listArticleData = "[{\"abstract\":\"Our daughter was becoming a mother in the most difficult of circumstances.\",\"id\":100000009457288,\"images\":\"https://static01.nyt.com/images/2024/05/14/opinion/12French1/12French1-mediumThreeByTwo440.jpg\",\"publishedDate\":\"2024-05-12\",\"section\":\"Opinion\",\"source\":\"New York Times\",\"subsection\":\"\",\"title\":\"‘Dad, I Don’t Think I’m Old Enough to Handle This’\",\"type\":\"Article\",\"url\":\"https://www.nytimes.com/2024/05/12/opinion/mothers-day-daughters-cancer.html\"},{\"abstract\":\"Young men are being tricked into sending naked pictures to scammers pretending to be women — who then demand money. The consequences can be devastating.\",\"id\":100000009319787,\"images\":\"https://static01.nyt.com/images/2024/04/24/nyregion/00sextortion/00sextortion-mediumThreeByTwo440.jpg\",\"publishedDate\":\"2024-05-15\",\"section\":\"New York\",\"source\":\"New York Times\",\"subsection\":\"\",\"title\":\"‘Chelsea’ Asked for Nude Pictures. Then the Sextortion Began.\",\"type\":\"Article\",\"url\":\"https://www.nytimes.com/2024/05/15/nyregion/social-media-scam-sextortion.html\"},{\"abstract\":\"In our latest focus group, these voters said Trump was fallible in any number of ways, but that’s not what they cared about most.\",\"id\":100000009468099,\"images\":\"https://static01.nyt.com/images/2024/05/15/opinion/trump-women-focus-group-1715708795597/trump-women-focus-group-1715708795597-mediumThreeByTwo440.png\",\"publishedDate\":\"2024-05-15\",\"section\":\"Opinion\",\"source\":\"New York Times\",\"subsection\":\"\",\"title\":\"These 12 Women Voted for Trump in 2020. How Do They See Him Now?\",\"type\":\"Interactive\",\"url\":\"https://www.nytimes.com/interactive/2024/05/15/opinion/trump-women-focus-group.html\"},{\"abstract\":\"A new set of Times/Siena polls, including one with The Philadelphia Inquirer, reveal an erosion of support for the president among young and nonwhite voters upset about the economy and Gaza.\",\"id\":100000009459687,\"images\":\"https://static01.nyt.com/images/2024/05/13/multimedia/13pol-poll-battlegrounds-topart-zjtf/13pol-poll-battlegrounds-topart-zjtf-mediumThreeByTwo440.jpg\",\"publishedDate\":\"2024-05-13\",\"section\":\"U.S.\",\"source\":\"New York Times\",\"subsection\":\"Politics\",\"title\":\"Trump Leads in 5 Key States, as Young and Nonwhite Voters Express Discontent With Biden\",\"type\":\"Article\",\"url\":\"https://www.nytimes.com/2024/05/13/us/politics/biden-trump-battleground-poll.html\"},{\"abstract\":\"A trial that is a meditation on Trump’s amorality.\",\"id\":100000009458621,\"images\":\"https://static01.nyt.com/images/2024/05/14/opinion/11dowd/11dowd-mediumThreeByTwo440.jpg\",\"publishedDate\":\"2024-05-11\",\"section\":\"Opinion\",\"source\":\"New York Times\",\"subsection\":\"\",\"title\":\"Donnie After Dark\",\"type\":\"Article\",\"url\":\"https://www.nytimes.com/2024/05/11/opinion/trump-stormy-daniels-trial.html\"}]"



    fun getNYTimesArticles(): NYTimesMostPopularResponse = serializeArticleData(data)

    fun getArticlesList() = listArticleData.jsonParse<List<Article>>()



}