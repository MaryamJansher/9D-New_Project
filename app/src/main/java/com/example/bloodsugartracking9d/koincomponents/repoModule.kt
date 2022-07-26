package com.example.bloodsugartracking9d.koincomponents

import org.koin.dsl.module

val repoModule = module {
    single {
        RepositoryKoin(get(), get())
    }
}