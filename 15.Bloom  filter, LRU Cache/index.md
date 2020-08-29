##Buru Filter, LRU Cache
<br></br>
###Traditional Way of Hash Table Storage
![Image of /hashtable_storage](imgs//hashtable_storage.jpg)
<br></br>
###Bloom filter is an advanced search which only tells if element may exists or not exists
###it is only used in the most-outer layer as a quick search cache
![Image of /bloom_filter](imgs//bloom_filter.jpg)
###Bloom filter uses bits to store info
![Image of /bloom_filter_1](imgs//bloom_filter_1.jpg)
###when find a item in the bloom filter which means it may exist, if not found means it is not in the filter 100%, in reality, if bloom filter find the search item, then the system will continue to search in the DB or other storage system
![Image of /bloom_filter_2](imgs//bloom_filter_2.jpg)
###Bloom filter usage
![Image of /bloom_filter_usage](imgs//bloom_filter_usage.jpg)
###Simple Bloom Filter - Java Implementation(refer to class: BloomFilter - https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)
<br></br>
<br></br>
##LRU Cache (LRU - least recently used)
![Image of /cpu_socket](imgs//cpu_socket.jpg)
###LRU Cache Implementation - HashTable + Double LinkedList
![Image of /lru_cache](imgs//lru_cache.jpg)
###LRU Cache Insert - How does it work - insert A -> B -> C -> D -> E -> F -> C -> G
![Image of /lru_cache_insert](imgs//lru_cache_insert.jpg)
![Image of /lru_strategy](imgs//lru_strategy.jpg)
