library(dplyr)
library(ggplot2)
library(readr)

quick <- read_csv("data/quick.csv")
heap <- read_csv("data/heap.csv")
median <- read_csv("data/median.csv")

#plot quick-select
quick %>% group_by(DimInput) %>%
  summarise(median_time = median(Tempo) / 10 ^ 9) %>%
  ggplot(aes(x = DimInput, y = median_time)) +
  geom_point(color = rgb(241, 151, 55, maxColorValue = 255)) + 
  xlab("input") + 
  ylab("tempo[s]")

ggsave("plots/quick/quick.jpg")

#plot heap-select
heap %>% group_by(DimInput) %>%
  summarise(median_time = median(Tempo) / 10 ^ 9) %>%
  ggplot(aes(x = DimInput, y = median_time)) +
  geom_point(color = rgb(241, 151, 55, maxColorValue = 255)) +
  xlab("input") + 
  ylab("tempo[s]")

ggsave("plots/heap/heap.jpg")

#plot median-select
median %>% group_by(DimInput) %>%
  summarise(median_time = median(Tempo) / 10 ^ 9) %>%
  ggplot(aes(x = DimInput, y = median_time)) +
  geom_point(color = rgb(241, 151, 55, maxColorValue = 255)) + 
  xlab("input") + 
  ylab("tempo[s]")

ggsave("plots/median/median.jpg")

#-------------------------------------------------------------------------------

#plot quick-select bilogaritmica
quick %>% group_by(DimInput) %>%
  summarise(median_time = median(Tempo) / 10 ^ 9) %>%
  ggplot(aes(x = log10(DimInput), y = log10(median_time))) +
  geom_point(color = rgb(241, 151, 55, maxColorValue = 255)) + 
  xlab("input") + 
  ylab("tempo[s]")

ggsave("plots/quick/quick_bilog.jpg")

#plot heap-select bilogaritmica
heap %>% group_by(DimInput) %>%
  summarise(median_time = median(Tempo) / 10 ^ 9) %>%
  ggplot(aes(x = log10(DimInput), y = log10(median_time))) +
  geom_point(color = rgb(241, 151, 55, maxColorValue = 255)) + 
  xlab("input") + 
  ylab("tempo[s]")

ggsave("plots/heap/heap_bilog.jpg")

#plot median-select bilogaritmica
median %>% group_by(DimInput) %>%
  summarise(median_time = median(Tempo) / 10 ^ 9) %>%
  ggplot(aes(x = log10(DimInput), y = log10(median_time))) +
  geom_point(color = rgb(241, 151, 55, maxColorValue = 255)) + 
  xlab("input") + 
  ylab("tempo[s]")

ggsave("plots/median/median_bilog.jpg")

#-------------------------------------------------------------------------------

#plot algoritmi a confronto scala bilogaritmica
ggplot(data = NULL,aes(x = log10(DimInput), y = log10(median_time))) +
  geom_point(aes(x = log10(DimInput), y = log10(median_time), color = "quick"), data = quick %>% group_by(DimInput) %>% summarise(median_time = median(Tempo) / 10 ^ 9)) + 
  geom_point(aes(x = log10(DimInput), y = log10(median_time), color = "heap"), data = heap %>% group_by(DimInput) %>% summarise(median_time = median(Tempo) / 10 ^ 9)) +
  geom_point(aes(x = log10(DimInput), y = log10(median_time), color = "median"), data = median %>% group_by(DimInput) %>% summarise(median_time = median(Tempo) / 10 ^ 9)) +
  xlab("input") + 
  ylab("tempo[s]") +
  labs(colour = "Algoritmo")

ggsave("plots/confronto.jpg")
