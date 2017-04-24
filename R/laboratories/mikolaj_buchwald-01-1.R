## To jest fragment kodu skryptu, ktÃ³ry byÅ‚ wykorzystany w konkursie
## Keggle i zajÄ…Å‚ 162 na ~4500 miejsce. A to jest dÅ‚ugi i bezsensowny
## komentarz, ktÃ³ry nic nie wnosi, brzydko wyglÄ…da ale pozwala
## przeÄ‡wiczyÄ‡ waÅ¼nÄ… umiejÄ™tnoÅ›Ä‡ :-)
nt <- read.csv("./data/NYTimesBlogTrain.csv", stringsAsFactor = F)
nt.test <- read.csv("./data/NYTimesBlogTest.csv", stringsAsFactor = F)
popular <- nt$Popular  # zapamiÄ™tuje
nt$Popular <- NULL  # usuwa
nt <- rbind(nt, nt.test)  # Å‚Ä…czy oba zbiory
nt$UniqueID <- NULL  # bezwartoÅ›ciowa zmienna
# filling gaps w tytuÅ‚ach, podtytuÅ‚ach i subtytuÅ‚ach
w <- nrow(nt)
# w <- 20
for (i in 1:w)
{
        if (nt[i, 2] == "")
                {
                            nt[i, 2] <- nt[i, 1]
                                }
}
for (i in 1:w)
{
        if (nt[i, 3] == "")
                {
                            nt[i, 3] <- nt[i, 2]
                                }
}
nt <- nt[, -c(1, 2)]  # wywalam niepotrzebne kolumny
nt$SubsectionName[grep("Daily Clip", nt$Headline)] <- "Daily Clip Report"
q <- grep("^Reading", nt$Headline)
for (i in q)
{
        if (nt[i, 1] == "")
                {
                            nt[i, 1] <- "Reading"
                                }
}
q <- c(grep("Sex", nt$Headline), grep("Nude", nt$Headline), grep("Love", 
    nt$Headline))
nt$SNL <- rep(0, nrow(nt))
nt$SNL[q] <- 1
nt$Questions <- rep(0, nrow(nt))
nt$Questions[grep("\\?$", nt$Headline)] <- 1
nt$Dwukropek <- rep(0, nrow(nt))
nt$Dwukropek[grep("\\:", nt$Headline)] <- 1
nt$Obama <- rep(0, nrow(nt))
nt$Obama[grep("Obama", nt$Headline)] <- 1
nt$Polit <- rep(0, nrow(nt))
nt$Polit[grep("Polit", nt$Headline)] <- 1
nt$SubsectionName <- as.factor(nt$SubsectionName)
