# helper
Helper functions for the pragmatic clojurian

## Installation

Make your `deps.edn` look like this:

```clojure
{:deps {coast-framework/helper {:git/url "https://github.com/coast-framework/helper"
                                :sha "04109855b5d7a7725c84a55eee4c18b6f9281cfa"}}}
```

## Usage

Require it like this

```clojure
(ns your-project
  (:require [helper.core :as helper]))
```

Check out src/test for which functions do what 😅.

## Testing

```sh
cd helper && make test
```

## License

MIT

## Contribution

Any and all issues or pull requests welcome!
