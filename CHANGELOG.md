# Change Log

## 23.0.0

* **Note:** Version 22.2.0 was accidentally released in a previous cycle. This release (23.0.0) supersedes it as the correct next major version.

### Summary of changes since 12.3.0

* [BREAKING] Changed `$sequence` type from `Long` to `String` for `Row` and `Document` models
* Added impersonation support: `setImpersonateUserId()`, `setImpersonateUserEmail()`, `setImpersonateUserPhone()` on `Client`
* Added `impersonator` and `impersonatorUserId` optional fields to `User` model
* Added `getHeaders()`, `getCookies(url)`, and `getHttpClient()` methods to `Client`
* Breaking: Channel factory methods require explicit IDs (no wildcard defaults)
* Added `ttl` parameter to `listDocuments` and `listRows` for caching
* Added `queries` parameter to Realtime subscriptions for filtering events
* Added array-based enum parameters (e.g., `permissions: List<BrowserPermission>`)
* Breaking: `Output` enum removed; use `ImageFormat` instead
* Added `Channel` helpers for Realtime
* Added `getScreenshot` method to `Avatars` service
* Added `Theme`, `Timezone`, and `Output` enums
* Added `total` parameter to list queries for skipping row counting
* Added `Operator` class for atomic modification of rows
* Added transaction support for Databases and TablesDB
* Deprecated `createVerification`; added `createEmailVerification` in `Account` service
* Added `incrementDocumentAttribute` and `decrementDocumentAttribute` to `Databases` service
* Added `gif` support to `ImageFormat` enum and `sequence` support to `Document` model
* Added `devKeys` support to `Client` and `upsertDocument` to `Databases` service
* Added `token` param to `getFilePreview` and `getFileView` for File tokens
* Fixed requests failing by removing `Content-Type` header from `GET` and `HEAD` requests

## 14.1.0

* Added `getHeaders()` method to `Client` for accessing current request headers
* Added `getCookies(url)` method to `Client` for retrieving cookies from the cookie store
* Added `getHttpClient()` method to `Client` for accessing the underlying OkHttpClient instance

## 14.0.0

* [BREAKING] Changed `$sequence` type from `Long` to `String` for `Row` and `Document` models
* Added impersonation support: `setImpersonateUserId()`, `setImpersonateUserEmail()`, `setImpersonateUserPhone()` on `Client`
* Added `impersonator` and `impersonatorUserId` optional fields to `User` model
* Updated `Log` model field descriptions to clarify impersonation behavior for `userId`, `userEmail`, `userName`
* Updated `X-Appwrite-Response-Format` header to `1.9.0`
* Updated API version badge to `1.9.0` and compatibility note to server version `1.9.x` in README

## 13.0.0

* Breaking: Channel factory methods require explicit IDs (no wildcard defaults)
* Added ttl parameter to listDocuments and listRows for caching
* Updated x-sdk-version header to 12.2.1 in Client
* Updated docs and examples to show TTL usage and latest compatibility note
* Updated Document and Row sequence descriptions in models

## 12.1.0

* Add `queries` parameter to Realtime subscriptions for filtering events
* Add `subscriptions` field to `RealtimeCallback` and `RealtimeResponseEvent` types
* Fix `Roles` enum removed from Teams service; `roles` parameter now accepts `List<String>`

## 12.0.0

* Add array-based enum parameters (e.g., `permissions: List<BrowserPermission>`).
* Breaking change: `Output` enum has been removed; use `ImageFormat` instead.
* Add `Channel` helpers for Realtime.

## 11.4.0

* Add `getScreenshot` method to `Avatars` service
* Add `Theme`, `Timezone` and `Output` enums

## 11.3.0

* Add `total` parameter to list queries allowing skipping counting rows in a table for improved performance
* Add `Operator` class for atomic modification of rows via update, bulk update, upsert, and bulk upsert operations

## 11.2.1

* Add transaction support for Databases and TablesDB

## 11.1.0

* Deprecate `createVerification` method in `Account` service
* Add `createEmailVerification` method in `Account` service

## 8.2.0

* Add `incrementDocumentAttribute` and `decrementDocumentAttribute` support to `Databases` service
* Add `gif` support to `ImageFormat` enum
* Add `sequence` support to `Document` model

## 8.1.0

* Add `devKeys` support to `Client` service
* Add `upsertDocument` support to `Databases` service

## 8.0.0

* Add `token` param to `getFilePreview` and `getFileView` for File tokens usage
* Update default `quality` for `getFilePreview` from 0 to -1
* Remove `Gif` from ImageFormat enum
* Remove `search` param from `listExecutions` method

## 7.0.1

* Fix requests failing by removing `Content-Type` header from `GET` and `HEAD` requests
