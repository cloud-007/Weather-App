package com.example.weatherapplicaion.Data

import com.example.weatherapplicaion.Model.CityItem

class DataSourceCity {
    companion object {
        fun createDataSet(): ArrayList<CityItem> {
            val list = ArrayList<CityItem>()

            list.add(
                CityItem(
                    "Sylhet",
                    "Bd"
                )
            )
            list.add(
                CityItem(
                    "Dhaka",
                    "Bd"
                )
            )
            list.add(
                CityItem(
                    "Rajshahi",
                    "Bd"
                )
            )
            list.add(
                CityItem(
                    "Rangpur",
                    "Bd"
                )
            )
            list.add(
                CityItem(
                    "Florida",
                    "USA"
                )
            )
            list.add(
                CityItem(
                    "Washington",
                    "USA"
                )
            )
            list.add(
                CityItem(
                    "London",
                    "Uk"
                )
            )
            list.add(
                CityItem(
                    "Sydney",
                    "Australia"
                )
            )
            list.add(
                CityItem(
                    "Melbourne",
                    "Australia"
                )
            )
            list.add(
                CityItem(
                    "Birmingham",
                    "UK",
                )
            )
            list.add(
                CityItem(
                    "Bali",
                    "Switzerland",
                )
            )
            list.add(
                CityItem(
                    "Kabul",
                    "Afghanistan",
                )
            )
            list.add(
                CityItem(
                    "Brasilia",
                    "Brazil",
                )
            )
            list.add(
                CityItem(
                    "Praia",
                    "Cape Verde",
                )
            )
            list.add(
                CityItem(
                    "Beijing",
                    "China",
                )
            )
            list.add(
                CityItem(
                    "Havana",
                    "Cuba",
                )
            )
            list.add(
                CityItem(
                    "Quito",
                    "Ecuador",
                )
            )
            list.add(
                CityItem(
                    "Berlin",
                    "Germany",
                )
            )
            list.add(
                CityItem(
                    "Dublin",
                    "Ireland",
                )
            )
            list.add(
                CityItem(
                    "Tokyo",
                    "Japan",
                )
            )
            list.add(
                CityItem(
                    "Male",
                    "Maldives",
                )
            )

            return list
        }
    }
}