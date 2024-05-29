### Searching for Products in an Order

Expected time required: 30 min

In this try, you will implement functionality to search an array and return an object by its `asin`.
The object to return is an Amazon package and the `AmazonPackage` class is provided for you.
It has the attributes:
- `asin`
- `shipDate`
- `estimatedDelivery`
- `category`

### Phase 1: Linear search

The class `AmazonOrderService` contains `findPackageLinear(String asin)`. In its current state,
the method does not do a search, rather it returns the first element, causing the
unit tests to fail. Implement `findPackageLinear()` so that it executes a linear search
and returns the `AmazonPackage` with the requested ASIN. If a package with the given ASIN
can't be found, the method should throw a `PackageNotFoundException`.

**You have completed phase 1 when:**

* You have implemented `findPackageLinear(String asin)` in the `AmazonOrder` class.
* The `AmazonOrderServicePhase1Test` tests are passing.
* You have committed and pushed your code.
* You have answered the Canvas quiz with a link to your commit on code browser.

### Phase 2: Binary search

`AmazonOrderService` also contains `findPackageBinary(String asin)`. Like the previous phase,
the method currently does not do a search, rather it returns the first element, causing the
unit tests to fail. Implement `findPackageBinary()` so that it executes a binary search
and returns the `AmazonPackage` with the requested ASIN. If a package with the given ASIN
can't be found, the method should throw a `PackageNotFoundException`.

Note: For the purposes of this activity, you can assume the list of packages has already
been sorted. You should not sort them again.

**You have completed phase 2 when:**

* You have implemented `findPackageBinary(String asin)` in the `AmazonOrder` class.
* The `AmazonOrderServicePhase2Test` tests are passing.

**You have completed this prework when:**

* You have implemented both `findPackageLinear` and `findPackageBinary` in `AmazonOrder`.
* The `AmazonOrderServicePhase2Test` tests are passing.
* You have committed and pushed your code.
* You have answered the Canvas quiz with a link to your commit on code browser.

HINT:

[I'm not sure how to do a linear search for the ASIN](./hints/hint_01.md)

[How do I track what I have left to search during binary search?](./hints/hint_02.md)

[What item should I be checking in each iteration of my binary search?](./hints/hint_03.md)

[How do I know when my binary search is done?](./hints/hint_04.md)
