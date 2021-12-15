# Stream Utils
[![CD](https://github.com/Florianisme/Stream-Utils/actions/workflows/cd.yml/badge.svg)](https://github.com/Florianisme/Stream-Utils/actions/workflows/cd.yml)
[![CI](https://github.com/Florianisme/Stream-Utils/actions/workflows/ci.yml/badge.svg)](https://github.com/Florianisme/Stream-Utils/actions/workflows/ci.yml)

## Overview
This project includes a few self-describing utility methods for dealing with Java Streams.
These methods make streams even more readable than they already are.


## Usage

### Add Dependency
```groovy
implementation 'de.florian-moehle:stream-utils:0.0.3'
```

## Classes

### Sorters ```.sorted()```
#### RandomSorter
Shuffle the elements of the stream randomly

### Filters ```.filter()```
#### ElementFilter
Filter generic null elements

#### StringFilter
Filter Strings that are either null or empty

### Collectors ```.collect()```
#### BinaryOperators
Helps you merge Map entries when dealing with duplicate keys
