package com.theveloper.pixelplay.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class SortOptionTest {

    @Test
    fun fromStorageKey_ignoresNullEntriesInAllowedCollection() {
        val allowedWithNull = listOf<SortOption?>(null, SortOption.AlbumTitleAZ)

        @Suppress("UNCHECKED_CAST")
        val unsafeAllowed = allowedWithNull as Collection<SortOption>

        val resolved = SortOption.fromStorageKey(
            SortOption.AlbumTitleAZ.storageKey,
            unsafeAllowed,
            SortOption.AlbumTitleZA
        )

        assertThat(resolved).isEqualTo(SortOption.AlbumTitleAZ)
    }
}
