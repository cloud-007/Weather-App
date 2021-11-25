import com.example.weatherapplicaion.Model.ExampleItem

class DataSourceWeather {
    companion object {
        fun createDataSet(): ArrayList<ExampleItem> {
            val list = ArrayList<ExampleItem>()
            list.add(
                ExampleItem(
                    "5.05 pm",
                    "28°C",
                    "0.01%"
                )
            )
            list.add(
                ExampleItem(
                    "6.05 pm",
                    "29°C",
                    "0.05%"
                )
            )
            list.add(
                ExampleItem(
                    "7.05 pm",
                    "21°C",
                    "0.02%"
                )
            )
            list.add(
                ExampleItem(
                    "8.05 pm",
                    "24°C",
                    "0.10%"
                )
            )
            list.add(
                ExampleItem(
                    "9.05 pm",
                    "16°C",
                    "0.12%"
                )
            )
            list.add(
                ExampleItem(
                    "10.05 pm",
                    "13°C",
                    "0.19%"
                )
            )
            list.add(
                ExampleItem(
                    "11.05 pm",
                    "11°C",
                    "0.11%"
                )
            )
            list.add(
                ExampleItem(
                    "12.05 am",
                    "10°C",
                    "0.19%"
                )
            )
            list.add(
                ExampleItem(
                    "01.05 am",
                    "10°C",
                    "0.12%"
                )
            )
            list.add(
                ExampleItem(
                    "02.05 am",
                    "12°C",
                    "0.21%"
                )
            )
            return list
        }
    }
}